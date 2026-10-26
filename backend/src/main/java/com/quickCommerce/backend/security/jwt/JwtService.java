package com.quickCommerce.backend.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    // SpEL (Spring Expression Language)
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    public String generateToken(String userId, String userRole){
        return Jwts.builder()   // it starts creating and now need to write what would be in the token
                .subject(userId)
                .claim("role", userRole)
                .signWith(getSecretKey()) // it takes cryptographic secret key not string so it took getSecretKey() which return cryptographic secret key
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .compact();
    }

    public String extractUserId(String token){
        return extratClaims(token)
                .getSubject();
    }

    public boolean isTokenExpired(String token){
        return extratClaims(token)
                .getExpiration().before(new Date());
    }

    private Claims extratClaims(String token) {
        return Jwts.parser()// for extract parser is required and for create  builder is required
                .verifyWith(getSecretKey())// this verify with the secret key what was signed in
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // this make our string secret key to cryptographic SecretKey.....what JJwt library understand
    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}
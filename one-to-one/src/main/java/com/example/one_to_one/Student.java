package com.example.one_to_one;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentRoll;
    private String studentName;
    private String studentEmail;

//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Address_id") // it is use to give this column name whre relation build
    private Address address;

}
/*
 * fetch type
 * one to one --> eager
 * many to one --> eager
 * many to many --> lazy
 * many to one --> lazy
 * */

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "emp_id")
    private String id;

    @Column(name = "emp_name", columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    /*
     * -- columndefinition -->> chnage datatype or u want to modify datatype then we
     * can use that
     * -- nullable --> here it is always false we can change it by this by using
     * this attribute
     * 
     * ---- unique -->this make unique elements are allowed
     * annotation
     */
    private String name;

    @Lob // String -> long text ,, byte[] --> BLOB, char[] --> CLOB
    private String description;

    
    private BigDecimal salary;

}
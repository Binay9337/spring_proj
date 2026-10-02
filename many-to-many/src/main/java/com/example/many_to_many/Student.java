package com.example.many_to_many;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String studentName;
    private String studentEmail;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "students_subjects",  // it change table name
            joinColumns = @JoinColumn(name = "student_id") ,  // it manage owning side col name what is in the table
            inverseJoinColumns = @JoinColumn(name = "subject_id") // it manage inverse side
    )
    private List<Subject> subjects;
}

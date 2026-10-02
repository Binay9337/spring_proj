package com.example.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String teacherName;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL) // if hre we dont use mapped by then another table will be created because of normalization
    private List<Subject> subjects;



}

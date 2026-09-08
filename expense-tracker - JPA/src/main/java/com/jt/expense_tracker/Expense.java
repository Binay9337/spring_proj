package com.jt.expense_tracker;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // create a non parameterized constructor
@AllArgsConstructor // create parameterized constrcutor will all args
@Getter // getter method
@Setter //
@ToString
@Entity // it is use to create table
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String category;
    private double price;
    private LocalDate expense_date;

}
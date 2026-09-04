package com.jt.expense_tracker;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // create a non parameterized constructor
@AllArgsConstructor // create parameterized constrcutor will all args
@Getter // getter method
@Setter //
@ToString
public class Expense {

    private int id;
    private String title;
    private String category;
    private double price;
    private LocalDate expense_date;

    // public Expense() {
    // }

    // public Expense(int id, String title, String category, double price, LocalDate
    // expense_date) {
    // this.id = id;
    // this.title = title;
    // this.category = category;
    // this.price = price;
    // this.expense_date = expense_date;
    // }

    // public int getId() {
    // return id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    // public String getTitle() {
    // return title;
    // }

    // public void setTitle(String title) {
    // this.title = title;
    // }

    // public String getCategory() {
    // return category;
    // }

    // public void setCategory(String category) {
    // this.category = category;
    // }

    // public double getPrice() {
    // return price;
    // }

    // public void setPrice(double price) {
    // this.price = price;
    // }

    // public LocalDate getExpense_date() {
    // return expense_date;
    // }

    // public void setExpense_date(LocalDate expense_date) {
    // this.expense_date = expense_date;
    // }

}
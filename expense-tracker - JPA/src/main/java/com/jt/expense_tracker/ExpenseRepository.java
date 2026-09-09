package com.jt.expense_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ExpenseRepository
 */


public interface ExpenseRepository extends JpaRepository<Expense, Integer>/* class name and type of primary key */ {
    
}

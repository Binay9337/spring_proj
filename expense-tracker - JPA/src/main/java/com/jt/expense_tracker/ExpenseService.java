package com.jt.expense_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    public final ExpenseRepository expenseRepository;

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(@PathVariable int id) {
        System.out.println("id is: " + id);

        Optional<Expense> optExp = expenseRepository.findById(id);

        // Expense expense = optExp.orElseThrow(); // if nothing is there then throw
        // no-suchelEmentException

        // return optExp.orElseThrow(() -> new RuntimeException("no such element"));
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("no such element"));

    }

    public Expense createExpense(@RequestBody Expense expense) {
        System.out.println("////////" + expense);

        return expenseRepository.save(expense);

    }

    public String deleteExpense(@PathVariable int id) {
        Expense toBeDeleted = getExpenseById(id);
        expenseRepository.deleteById(id);
        // expenseRepository.delete(toBeDeleted);
        return "id is deleted";
    }

    public Expense updatExpense(@RequestBody Expense expense) {

        getExpenseById(expense.getId());
        return expenseRepository.save(expense); // save does if this object is thre then update if not then create

    }

}

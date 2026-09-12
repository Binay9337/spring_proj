/* package com.jt.expense_tracker;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequiredArgsConstructor // it only take instance and final
public class ExpensesController {

    // private final JdbcTemplate jdbcTemplate;
    private final ExpenseRepository expenseRepository;
    private static final String EXP_TABLE = "expenses";

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id) {
        System.out.println("id is: " + id);

        Optional<Expense> optExp = expenseRepository.findById(id);

        // Expense expense = optExp.orElseThrow(); // if nothing is there then throw
        // no-suchelEmentException

        // return optExp.orElseThrow(() -> new RuntimeException("no such element"));
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("no such element"));

    }

    @PostMapping("/expenses")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Expense createExpense(@RequestBody Expense expense) {
        System.out.println("////////" + expense);

        return expenseRepository.save(expense);

    }

    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT) // if u have no return then -- 204
    public String deleteExpense(@PathVariable int id) {
        Expense toBeDeleted = getExpenseById(id);
        expenseRepository.deleteById(id);
        // expenseRepository.delete(toBeDeleted);
        return "id is deleted";
    }

    @PutMapping("/expenses")
    @ResponseStatus(HttpStatus.ACCEPTED) // when update ---- 202
    public Expense updatExpense(@RequestBody Expense expense) {

        getExpenseById(expense.getId());
        return expenseRepository.save(expense); // save does if this object is thre then update if not then create

    }

}
 */

package com.jt.expense_tracker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * ExpensesController
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class ExpensesController {

    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id) {
        return expenseService.getExpenseById(id);

    }

    @PostMapping("/expenses")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);

    }

    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT) // if u have no return then -- 204
    public String deleteExpense(@PathVariable int id) {
        return expenseService.deleteExpense(id);

    }

    @PutMapping("/expenses")
    @ResponseStatus(HttpStatus.ACCEPTED) // when update ---- 202
    public Expense updatExpense(@RequestBody Expense expense) {

        return expenseService.updatExpense(expense);

    }
}
package com.jt.expense_tracker;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;
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

@RestController
@RequiredArgsConstructor // it only take instance and final
public class ExpensesController {

    private final JdbcTemplate jdbcTemplate;
    private static final String EXP_TABLE = "expenses";

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public List<Expense> getExpenses() {

        String sql = "SELECT * FROM expenses";

        var expense = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

        return expense;

    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id) {
        System.out.println("id is: " + id);

        var sql = "select * from expenses where id = ?";
        Expense expense = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Expense>(Expense.class), id);
        return expense;
    }

    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense) {
        System.out.println("////////" + expense);

        var sql = "insert into %s (title, category,price,expense_date) values (?,?,?,?)".formatted(EXP_TABLE);

        jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), expense.getPrice(),
                expense.getExpense_date());

        return expense;
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable int id) {
        var sql = "DELETE FROM %S WHERE id = ?".formatted(EXP_TABLE);
        jdbcTemplate.update(sql, id);
        return id + " deleted";
    }

    @PutMapping("/expenses")
    public Expense updatExpense(@RequestBody Expense expense) {

        var sql = "UPDATE %s SET title = ?, category = ?, price = ?, expense_date = ? WHERE id = ?"
                .formatted(EXP_TABLE);

        jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), expense.getPrice(),
                expense.getExpense_date(), expense.getId());

        return getExpenseById(expense.getId());

    }

}

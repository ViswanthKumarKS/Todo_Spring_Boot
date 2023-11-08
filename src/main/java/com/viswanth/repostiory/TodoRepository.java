package com.viswanth.repostiory;


import com.viswanth.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findall() {
        return jdbcTemplate.query("SELECT * FROM todo",new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insert(Todo todo) {
       jdbcTemplate.update("INSERT INTO todo(name,gender)values(?,?)",new Object[]{todo.getName(),todo.getGender()});


        return findall();
    }

    public List<Todo> update(Todo todo) {
        jdbcTemplate.update("UPDATE todo SET name=?, gender=? WHERE id=?;",
                new Object[]{todo.getName(),todo.getGender(),todo.getId()});
        return findall();
    }

    public List<Todo> delete(int id) {
        jdbcTemplate.update("DELETE FROM todo WHERE ID=?;",
                new Object[]{id});
        return findall();
    }
}


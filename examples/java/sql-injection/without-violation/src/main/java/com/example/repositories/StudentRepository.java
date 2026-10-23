package com.example.repositories;

import com.example.models.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findByAge(int age) {

        String sql = """
                SELECT id, name, age, active
                FROM students
                WHERE age = ?""";

        System.out.println(sql);

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getBoolean("active")
                        ),
                age
        );
    }
}

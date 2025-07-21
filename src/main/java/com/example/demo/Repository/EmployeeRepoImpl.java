package com.example.demo.Repository;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private final RowMapper<Employee> rowMapper = (rs, rowNum) -> {
        Employee emp = new Employee();
        emp.setEmpId(rs.getInt(1));
        emp.setEmpName(rs.getString(2));
        emp.setLocation(rs.getString(3));
        return emp;
    };

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", rowMapper);
    }

    @Override
    public Optional<Employee> findById(int id) {
        String query = "select * from employee where emp_id =?";
        return jdbcTemplate.query(query, rowMapper, id)
                .stream().findFirst();
    }

    @Override
    public int save(Employee emp) {
        String query = "insert into employee values (?, ?, ?)";
        return jdbcTemplate.update(query, emp.getEmpId(), emp.getEmpName(), emp.getLocation());
    }

    @Override
    public int update(Employee emp) {
        String query = "update employee set emp_name = ?, location = ? where emp_id = ?";
        return jdbcTemplate.update(query, emp.getEmpName(), emp.getLocation(), emp.getEmpId());
    }

    @Override
    public int delete(int id) {
        String query = "delete from employee where emp_id = ?";
        return jdbcTemplate.update(query, id);
    }
}

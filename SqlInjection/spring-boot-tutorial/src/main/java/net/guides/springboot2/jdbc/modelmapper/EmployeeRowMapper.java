package net.guides.springboot2.jdbc.modelmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.guides.springboot2.jdbc.model.Employee;

public class EmployeeRowMapper implements RowMapper < Employee > {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setEmailId(rs.getString("email_address"));
        return employee;
    }

}

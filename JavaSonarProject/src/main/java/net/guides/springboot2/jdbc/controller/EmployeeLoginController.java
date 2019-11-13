package net.guides.springboot2.jdbc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.jdbc.model.Employee;
import net.guides.springboot2.jdbc.modelmapper.EmployeeRowMapper;

@RestController
@RequestMapping("/login")
public class EmployeeLoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    JdbcTemplate jdbcTemplate;

	@RequestMapping(path="/allemployees", method=RequestMethod.POST)
	public List<Employee> getAllEmployess() {
		return findAll();
	}

	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public List<Employee> getProductsByName(@RequestParam String uId) {

		// Removing the Vulnerable Code
		boolean isVulnerable = false;

		// Vulnerable Function
		if(isVulnerable)
			return findByIdVulnerable(uId);

		// Non Vulnerable Function
		return findByIdNonVulnerable(uId);
	}


    public List < Employee > findAll() {
        return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());
    }

    public List <Employee> findByIdVulnerable(String id) {
    	String query = "select * from employees where id=" + id ;
    	RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<> (Employee.class);
    	return jdbcTemplate.query(query, rowMapper);
    }



    public List <Employee> findByIdNonVulnerable(String id) {
    	int uid;
		try { uid = Integer.parseInt(id); }
		catch(Exception ex) {
			logger.error(ex.getMessage());
			return new ArrayList<>();
		}

    	String query = "select * from employees where id=? ";
    	Object[] conditions = { uid };
    	RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<> (Employee.class);
    	return jdbcTemplate.query(query, conditions, rowMapper);
    }

}

package net.guides.springboot2.jdbc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class EmployeeLoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public String getProductsByName(@RequestParam String uName, @RequestParam String uPwd, HttpServletResponse resp,
			HttpSession httpSession) {

		String message = "Login Page Executed Successfully";
		logger.info(message);
		return new JSONObject().put("message", message).toString();
	}

}

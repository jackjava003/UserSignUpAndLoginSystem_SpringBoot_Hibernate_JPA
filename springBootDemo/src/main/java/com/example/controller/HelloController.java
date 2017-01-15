package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.MemberBean;
import com.example.service.JoinService;
import com.example.service.GlobalService;

@Controller
public class HelloController {
	@Value("${test}")
	private String test;
	@Value("${joinOK}")
	private String joinOK;
	@Value("${joinNG}")
	private String joinNG;
	@Value("${loginNG}")
	private String loginNG;

	@Autowired
	JoinService joinService;

	@Autowired
	GlobalService globalService;

	@RequestMapping("/")
	public String helloPage(Map<String, Object> model, HttpSession httpSession) {
		if (httpSession != null && httpSession.getAttribute("LoginOK") != null) {
			httpSession.removeAttribute("LoginOK");
		}
		model.put("message", this.test);
		return "welcome";
	}

	@RequestMapping("/hello/{name}")
	public @ResponseBody String hello(@PathVariable("name") String name) {
		return test + " " + name;
	}

	@RequestMapping("/Test")
	public @ResponseBody String test(Map<String, Object> model) {
		model.put("test", this.test);
		return "Test";
	}

	@RequestMapping(value = "/UserSubmit", method = RequestMethod.POST)
	public String userSubmit(@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, Model model, HttpSession httpSession) {
		// System.out.println(firstName + " " + lastName + " " + email + " " +
		// password);
		String encryptPassword = globalService.getMD5Endocing(globalService.encryptString(password));
		MemberBean mb = joinService.addUser(firstName, lastName, email, encryptPassword);
		if (mb != null) {
			model.addAttribute("msg", joinOK + mb.getUserID());
			model.addAttribute("firstJoin", true);
			httpSession.setAttribute("LoginOK", mb);
		} else {
			model.addAttribute("msg", joinNG);
			return "welcome";
		}
		return "member";
	}

	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public String loginSubmit(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, Model model, HttpSession httpSession) {
		String encryptPassword = globalService.getMD5Endocing(globalService.encryptString(password));
		MemberBean mb = joinService.logIn(email, encryptPassword);
		if (mb != null) {
			model.addAttribute("msg", joinOK + mb.getUserID());
			httpSession.setAttribute("LoginOK", mb);
		} else {
			model.addAttribute("msg", loginNG);
			return "welcome";
		}
		return "member";
	}
}

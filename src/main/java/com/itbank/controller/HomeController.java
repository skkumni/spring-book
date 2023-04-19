package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.TestService;

@Controller
public class HomeController {
	
	@Autowired private TestService testService;
	
	@RequestMapping("/")	// "http://localhost:8080/day07" + "/"
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		String version = testService.getDBversion();
		mav.addObject("version", version);
		return mav;
	}

}

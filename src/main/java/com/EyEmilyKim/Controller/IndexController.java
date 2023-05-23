package com.EyEmilyKim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("index")
	public String index() {
		System.out.println("IndexController > index() called");
		return "root.index";
	}
}

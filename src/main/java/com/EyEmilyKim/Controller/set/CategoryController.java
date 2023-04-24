package com.EyEmilyKim.Controller.set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/set/category/")
public class CategoryController {
	
	@RequestMapping("list")
	public String list() {
		return "set.category.list";
	}
}

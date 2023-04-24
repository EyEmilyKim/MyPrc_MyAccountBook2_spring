package com.EyEmilyKim.controller.set;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EyEmilyKim.entity.Category;
import com.EyEmilyKim.service.CategoryService;

@Controller
@RequestMapping("/set/category/")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Category> list = categoryService.getList("master");
		model.addAttribute("LIST", list);
		return "set.category.list";
	}
}

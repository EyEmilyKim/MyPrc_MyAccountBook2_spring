package com.EyEmilyKim.controller.set;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EyEmilyKim.entity.Category;
import com.EyEmilyKim.service.CategoryService;

@Controller
@RequestMapping("/set/category/")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	private String failMsg = "해당 기능이 준비되지 않아 처리하지 못했습니다.";
	private String succMsg = "정상적으로 처리되었습니다.";
	private String nextUrl = "/set/category/list";
	
	@RequestMapping("list")
	public String list(@RequestParam(name="ID", defaultValue="master", required=false)String ID, Model model) {
		System.out.println("CategoryController > list() called");
		List<Category> list = categoryService.getList(ID);
		model.addAttribute("LIST", list);
		int cnt = categoryService.getCount("master");
		model.addAttribute("COUNT", cnt);
		return "set.category.list";
	}
	
	@GetMapping("add")
	public String add(@RequestParam(name="ID", defaultValue="master", required=false)String ID, Model model) {
		System.out.println("CategoryController > add()@Get called");
		List<Category> list = categoryService.getList(ID);
		model.addAttribute("LIST", list);
		int seqno = categoryService.getSeqno();
		model.addAttribute("MSN", seqno);
		return "set.category.add";
	}
	@PostMapping("add")
	public String add(int SEQNO, String INEX, String CNAME, @RequestParam(name="ID", defaultValue="master", required=false)String ID, Model model) {
		System.out.println("CategoryController > add()@Post called");
		Category cate = new Category();
		cate.setSeqno(SEQNO);
		cate.setInex(INEX);
		cate.setCate_name(CNAME);
		cate.setCate_code(INEX+SEQNO);
		cate.setId(ID);
		int flag = categoryService.insert(cate);
		System.out.println("flag : "+flag);
		if(flag==0) {
			model.addAttribute("msg", failMsg);
			model.addAttribute("url", nextUrl);
		}else {
			model.addAttribute("msg", succMsg);
			model.addAttribute("url", nextUrl);
		}
		return "redirect";
	}
	
	@GetMapping("del")
	public String del(String CCODE, Model model) {
		System.out.println("CategoryController > del()@Get called");
		Category cate = categoryService.select(CCODE);
		System.out.println(cate.getCate_code());
		System.out.println(cate.getCate_name());
		model.addAttribute("C", cate);
		return "set.category.del";
	}
	@PostMapping("del")
	public String del(String CCODE, Model model, String CNAME) {
		System.out.println("CategoryController > del()@Post called");
		System.out.println("CCODE : "+CCODE);
		int flag = categoryService.delete(CCODE);
		System.out.println("flag : "+flag);
		if(flag==0) {
			model.addAttribute("msg", failMsg);
			model.addAttribute("url", nextUrl);
		}else {
			model.addAttribute("msg", succMsg);
			model.addAttribute("url", nextUrl);
		}
		return "redirect";
	}
}

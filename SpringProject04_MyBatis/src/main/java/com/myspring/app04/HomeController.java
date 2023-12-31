package com.myspring.app04;

import java.text.DateFormat;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.model.PersonService;
import com.myspring.vo.Person4;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private PersonService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//추가폼
	@GetMapping("per_insert")
	public String insert() {
		return "insert";
	}
	@PostMapping("per_insert")
	public String insert(@ModelAttribute Person4 person) {
		service.insert(person);
		return "redirect:per_list";
	}
	@GetMapping("per_list")
	public String list(String field, String word,Model model) {
		//List<Person4> arr = service.listAll();
	//	int count = service.countAll();
		
		List<Person4> arr = service.list(field, word);
		int count = service.count(field, word);
		model.addAttribute("personlist", arr);
		model.addAttribute("count", count);
		return "list";
	}
	//상세보기
	@GetMapping({"view","update"})
	public void view(String id, Model model) {
		Person4 person =service.view(id);
		model.addAttribute("person", person);
	}
	//수정
	@PostMapping("update")
	public String update(Person4 person) {
		service.update(person);
		return "redirect:per_list";
	}
	
//	@GetMapping("update")
//	public String update(String id, Model model) {
//		Person4 person =service.view(id);
//		model.addAttribute("person", person);
//		return "update";
//		
//	}
	@GetMapping("delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:per_list";
	}
	
	
}








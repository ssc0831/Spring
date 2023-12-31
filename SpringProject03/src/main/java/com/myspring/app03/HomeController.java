package com.myspring.app03;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.model.MPersonDAOImpl;
import com.myspring.model.Person3;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MPersonDAOImpl dao;
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
 @GetMapping("insert")
 public String insert() {
	 return "personForm";
 }
 @PostMapping("insert")
 public String insert(Person3 person) {
	 dao.per_insert(person);
	 return "redirect:list";
 }
 @GetMapping("list")
 public String list(Model model) {
	 List<Person3> arr =  dao.per_list();
	 model.addAttribute("personlist", arr);
	 model.addAttribute("count", dao.per_count());
	 
	 return "personList";
 }
 //상세보기, 수정폼
 @GetMapping({"view","update"})
 public void view(String id,Model model) {
	 Person3 person = dao.per_view(id);
	 model.addAttribute("person", person);
 }
// @GetMapping("view")
//public String view(String id,Model model) {
//	 Person3 person = dao.per_view(id);
//	 model.addAttribute("person", person);
//	 return "personView";
// }
// 
// @GetMapping("update")
//public String update(String id,Model model) {
//	 Person3 person = dao.per_view(id);
//	 model.addAttribute("person", person);
//	 return "personUpdate";
// }
 @PostMapping("update")
public String update(Person3 person) {
	  dao.per_update(person);
	  return "redirect:list";
 }
 
 @GetMapping("delete")
 public String delete(String id) {
	 dao.per_delete(id);
	
	 return "redirect:list";
 }
	
	
	
	
	
	
	
	
	
	
}

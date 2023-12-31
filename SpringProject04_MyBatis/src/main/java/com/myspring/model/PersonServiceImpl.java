package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.vo.Person4;
@Service
public class PersonServiceImpl  implements PersonService{
   @Autowired
   private PersonDAO dao;
	@Override
	public void insert(Person4 person) {
		dao.dao_insert("personInsert",person);
		
	}

	@Override
	public List<Person4> listAll() {
			return dao.dao_listAll("personlist");
	}

	@Override
	public List<Person4> list(String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		return dao.dao_list("searchPerson", hm);
	}

	@Override
	public Person4 view(String id) {
		return dao.dao_view("personview", id);
	}

	@Override
	public void update(Person4 person) {
		dao.dao_update("personupdate", person);		
	}

	@Override
	public void delete(String id) {
		dao.dao_delete("persondelete", id);
		
	}

	@Override
	public int countAll() {
			return dao.dao_countAll("personcount");
	}

	@Override
	public int count(String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		 return  dao.dao_count("searchCount", hm);
	}

}

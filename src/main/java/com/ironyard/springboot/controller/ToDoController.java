package com.ironyard.springboot.controller;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ironyard.repo.NotePadRepository;
import com.ironyard.repo.ToDoRepository;
import com.ironyard.springboot.data.NotePad;
import com.ironyard.springboot.data.ToDoItem;

@RestController
public class ToDoController {
	
	@Autowired
	private ToDoRepository myToDoRepo;
	
	@Autowired
	private NotePadRepository myNotepadRepo;
	

	@RequestMapping(value = "/notepad", method = RequestMethod.POST)
	public NotePad create(@RequestBody NotePad createThis){
		myNotepadRepo.save(createThis);
		return createThis;
	}
	
	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public ToDoItem create(@RequestBody ToDoItem createThis){
		myToDoRepo.save(createThis);
		return createThis;
	}
	
	/**
	 * Get the specified Item
	 * @param id
	 * @return requested ToDoItem
	 */
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public ToDoItem get(@PathVariable Long id){
		// set ID
		return myToDoRepo.findOne(id);
	}
	
	/**
	 * 
	 * @return Collection of all ToDoItems
	 */
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public Page get(@RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam(value = "sortby", required = false) String sortby,
            @RequestParam(value = "dir", required = false) Sort.Direction direction) {


		// DEFAULT Sort property
		if (sortby == null) {
			sortby = "title";
		}
		
		// DEFAULT Sort direction
		if (direction == null) {
			direction = Sort.Direction.DESC;
		}
		
		Sort s = new Sort(direction, sortby);
		PageRequest pr = new PageRequest(page, size, s);
		Page data =  myToDoRepo.findAll(pr);		
		return data;
	}
}

package com.ironyard.springboot.controller;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ironyard.springboot.data.ToDoItem;

@RestController
public class ToDoController {
	
	private HashMap<Long, ToDoItem> tempStore = new HashMap<Long, ToDoItem>();
	
	/**
	 * Create the specified ToDoItem
	 * @param createThis
	 * @return populated ToDoItem
	 */
	@RequestMapping(value = "/todoitems", method = RequestMethod.POST)
	public ToDoItem create(@RequestBody ToDoItem createThis){
		// set ID
		createThis.setId(System.currentTimeMillis());
		// store it
		tempStore.put(createThis.getId(), createThis);
		return createThis;
	}
	
	/**
	 * Get the specified Item
	 * @param id
	 * @return requested ToDoItem
	 */
	@RequestMapping(value = "/todoitems/{id}", method = RequestMethod.GET)
	public ToDoItem get(@PathVariable Long id){
		// set ID
		return tempStore.get(id);
	}
	
	/**
	 * 
	 * @return Collection of all ToDoItems
	 */
	@RequestMapping(value = "/todoitems", method = RequestMethod.GET)
	public Collection<ToDoItem> get() {
		// set ID
		return tempStore.values();
	}
}

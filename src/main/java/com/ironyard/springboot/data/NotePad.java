package com.ironyard.springboot.data;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NotePad {
	
	private String name;
	private String desc;
	
	@Id
    @GeneratedValue
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ToDoItem> items;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<ToDoItem> getItems() {
		return items;
	}
	public void setItems(List<ToDoItem> items) {
		this.items = items;
	}
	
	
	
	

}

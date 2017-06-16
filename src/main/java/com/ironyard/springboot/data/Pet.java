package com.ironyard.springboot.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {
	private String name;
	private final boolean goodboy = true;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String type;
	private String breed;
	
	private boolean wellBehaved;
	private int age;
	@Id
	@GeneratedValue
	private long Id;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public boolean isWellBehaved() {
		return wellBehaved;
	}
	public void setWellBehaved(boolean wellBehaved) {
		this.wellBehaved = wellBehaved;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}

}

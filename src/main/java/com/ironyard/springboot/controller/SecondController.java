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

import com.ironyard.repo.PetOwnerRepo;
import com.ironyard.repo.PetRepo;
import com.ironyard.springboot.data.Pet;
import com.ironyard.springboot.data.PetOwner;

@RestController
public class SecondController {

	@Autowired
	private PetOwnerRepo ownerRepo;
	@Autowired
	private PetRepo petRepo;
	
	
	/**
	 * Create the specified PetOwner
	 * @param createThis
	 * @return populated PetOwner
	 */
	
	@RequestMapping(value = "/petowners", method = RequestMethod.POST)
	public PetOwner createOwner(@RequestBody PetOwner createThis){
		
		ownerRepo.save(createThis);
		return createThis;
	}
	
	/**
	 * Get the specified Owner
	 * @param id
	 * @return requested PetOwner
	 */
	@RequestMapping(value = "/petowners/{id}", method = RequestMethod.GET)
	public PetOwner getOwner(@PathVariable Long id){
		// set ID
		
		return ownerRepo.findOne(id);
	}
	
	@RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
	public Pet getPet(@PathVariable Long id){
		// set ID
		
		return petRepo.findOne(id);
	}
	@RequestMapping(value = "/petowners", method = RequestMethod.PUT)
	public PetOwner updateOwner(@RequestBody PetOwner createThis){
		// set ID
		
		ownerRepo.save(createThis);
		return createThis;
	}
	@RequestMapping(value = "/pets", method = RequestMethod.PUT)
	public Pet updatePet(@RequestBody Pet createThis){
		// set ID
		
		petRepo.save(createThis);
		return createThis;
	}

	
	/**
	 * 
	 * @return Collection of all PetOwners
	 */
	@RequestMapping(value = "/petowners", method = RequestMethod.GET)
	public Page get(@RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam(value = "sortby", required = false) String sortBy,
            @RequestParam(value = "dir", required = false) Sort.Direction direction) {


		// DEFAULT Sort property
		if (sortBy == null) {
			sortBy = "id";
		}
		
		// DEFAULT Sort direction
		if (direction == null) {
			direction = Sort.Direction.DESC;
		}
		
		Sort s = new Sort(direction, sortBy);
		PageRequest pr = new PageRequest(page, size, s);
		Page data =  ownerRepo.findAll(pr);		
		
		
		Page data2 =  ownerRepo.findAll(new PageRequest(page, size, new Sort(direction, sortBy)));		
		return data;
	}
	
}

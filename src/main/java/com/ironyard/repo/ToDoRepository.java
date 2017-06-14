package com.ironyard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironyard.springboot.data.ToDoItem;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long>{

}

package com.ironyard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironyard.springboot.data.NotePad;

public interface NotePadRepository extends JpaRepository<NotePad, Long>{

}

package com.ironyard.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.ironyard.springboot.data.PetOwner;

public interface PetOwnerRepo extends PagingAndSortingRepository<PetOwner, Long>{

}

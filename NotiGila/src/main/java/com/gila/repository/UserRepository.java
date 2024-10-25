package com.gila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gila.jpa.model.User;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	User findByName(String username);
}

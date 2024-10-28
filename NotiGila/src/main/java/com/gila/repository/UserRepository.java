package com.gila.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gila.jpa.model.User;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	User findByName(String username);
	List<User> findByCategory(String category);
}

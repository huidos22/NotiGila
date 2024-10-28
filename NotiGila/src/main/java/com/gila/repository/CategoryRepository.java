package com.gila.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gila.jpa.model.Category;
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByName(String categoryName);
}

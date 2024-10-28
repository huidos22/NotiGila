package com.gila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gila.jpa.model.Message;
@RepositoryRestResource
public interface MessageRepository extends JpaRepository<Message, Integer> {

}

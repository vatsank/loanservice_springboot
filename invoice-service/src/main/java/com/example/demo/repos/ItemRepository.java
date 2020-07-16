package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Item;

@RepositoryRestResource(path = "items")
public interface ItemRepository extends JpaRepository<Item, Integer> {

}

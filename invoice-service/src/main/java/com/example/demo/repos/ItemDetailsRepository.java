package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.ItemDetails;

@RepositoryRestResource(path = "itemdetails")
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer> {

}

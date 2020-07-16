package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.HateosInvoice;

@Repository
public interface HateosInvoiceRepository extends JpaRepository<HateosInvoice, Integer> {

}

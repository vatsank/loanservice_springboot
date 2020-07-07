package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CibilScore;

@Repository
public interface CibilScoreRepository extends JpaRepository<CibilScore, Integer> {

}

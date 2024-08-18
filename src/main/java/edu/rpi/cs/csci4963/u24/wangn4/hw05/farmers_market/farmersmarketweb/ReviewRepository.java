package edu.rpi.cs.csci4963.u24.wangn4.hw05.farmers_market.farmersmarketweb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
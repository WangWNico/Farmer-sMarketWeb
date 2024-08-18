package edu.rpi.cs.csci4963.u24.wangn4.hw05.farmers_market.farmersmarketweb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmersMarketRepository extends JpaRepository<FarmersMarket, Integer> {
}
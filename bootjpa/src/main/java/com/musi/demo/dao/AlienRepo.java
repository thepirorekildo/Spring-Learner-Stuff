package com.musi.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musi.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	 
	List<Alien> findByAname(String aname);

	List<Alien> findByAidGreaterThan(int aid);
	
	
}

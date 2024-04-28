package com.example.farmcollector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.farmcollector.repository.model.FarmCropsEntity;

public interface FarmCollectorRepository extends JpaRepository<FarmCropsEntity, Long> {

	FarmCropsEntity save(FarmCropsEntity plantedCropsEntity); 
	List<FarmCropsEntity> findByFarmName(String farmName);
	List<FarmCropsEntity> findBySeason(String season);
	 

}

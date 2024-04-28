package com.example.farmcollector.service;

import java.util.List;

import com.example.farmcollector.model.HarvestedCropsResponse;
import com.example.farmcollector.model.PlantedCropsResponse;
import com.example.farmcollector.repository.model.FarmCropsEntity;

public interface FarmCollectorService {

	FarmCropsEntity savePlantedCropsdata(FarmCropsEntity plantedCropsEntityReq);
	
	List<FarmCropsEntity> getPlantedCropsEntity();
	List<FarmCropsEntity> getCropsByFarm(String farmName);
	List<FarmCropsEntity> getCropsBySeason(String season);
	
	List<PlantedCropsResponse> getPlantedCropsByFarm(String farmName);
	List<HarvestedCropsResponse> getHarvestedCropsByFarm(String farmName);
}

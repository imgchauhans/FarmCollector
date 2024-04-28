package com.example.farmcollector.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.farmcollector.model.HarvestedCropsResponse;
import com.example.farmcollector.model.PlantedCropsResponse;
import com.example.farmcollector.repository.FarmCollectorRepository;

import com.example.farmcollector.repository.model.FarmCropsEntity;

@Service
public class FarmCollectorServiceImpl implements FarmCollectorService {

	@Autowired
	FarmCollectorRepository farmColelctorRepo;

	@Override
	public FarmCropsEntity savePlantedCropsdata(FarmCropsEntity plantedCropsEntityReq) {
		// TODO Auto-generated method stub
		return farmColelctorRepo.save(plantedCropsEntityReq);
	}

	@Override
	public List<FarmCropsEntity> getPlantedCropsEntity() {
		// TODO Auto-generated method stub
		return farmColelctorRepo.findAll();
	}

	@Override
	public List<PlantedCropsResponse> getPlantedCropsByFarm(String farmName) {
		// TODO Auto-generated method stub

		List<PlantedCropsResponse> plantedCropRespList = new ArrayList<>();

		List<FarmCropsEntity> plantedCropsList = farmColelctorRepo.findByFarmName(farmName);
		;

		for (FarmCropsEntity respEntity : plantedCropsList) {
			PlantedCropsResponse plantedCropResp = new PlantedCropsResponse();
			plantedCropResp.setFarmName(respEntity.getFarmName());
			plantedCropResp.setPlantedArea(respEntity.getPlantedArea());
			plantedCropResp.setCropType(respEntity.getCropType());
			plantedCropResp.setExpectedProduce(respEntity.getExpectedProduce());
			plantedCropResp.setSeason(respEntity.getSeason());
			plantedCropRespList.add(plantedCropResp);
		}
		return plantedCropRespList;
	}

	@Override
	public List<HarvestedCropsResponse> getHarvestedCropsByFarm(String farmName) {
		// TODO Auto-generated method stub

		List<HarvestedCropsResponse> harvestedCropResponseList = new ArrayList<>();
		List<FarmCropsEntity> plantedCropsList = farmColelctorRepo.findByFarmName(farmName);

		for (FarmCropsEntity respEntity : plantedCropsList) {
			HarvestedCropsResponse harvestedCropResp = new HarvestedCropsResponse();
			harvestedCropResp.setFarmName(respEntity.getFarmName());
			harvestedCropResp.setPlantedArea(respEntity.getPlantedArea());
			harvestedCropResp.setCropType(respEntity.getCropType());
			harvestedCropResp.setHarvestedProduce(respEntity.getHarvestedProduce());
			harvestedCropResp.setSeason(respEntity.getSeason());
			harvestedCropResponseList.add(harvestedCropResp);
		}
		return harvestedCropResponseList;
	}

	@Override
	public List<FarmCropsEntity> getCropsByFarm(String farmName) {
		// TODO Auto-generated method stub
		return farmColelctorRepo.findByFarmName(farmName);
	}

	@Override
	public List<FarmCropsEntity> getCropsBySeason(String season) {
		// TODO Auto-generated method stub
		return farmColelctorRepo.findBySeason(season);
	}

}

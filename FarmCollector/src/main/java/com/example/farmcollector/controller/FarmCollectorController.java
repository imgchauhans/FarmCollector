package com.example.farmcollector.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.farmcollector.model.PlantedCropsResponse;
import com.example.farmcollector.repository.model.FarmCropsEntity;
import com.example.farmcollector.service.FarmCollectorService;
import com.example.farmcollector.service.FarmCollectorServiceImpl;

/**
 * @author DELL
 *
 */
@RestController
public class FarmCollectorController {

	@Autowired
	FarmCollectorService farmColelctorService;

	/**
	 * This method is giving you functioanlity to create the Farm Data
	 * @param plantedCropsRequest
	 * @return
	 */
	@PostMapping("/farms")
	public ResponseEntity saveFarmPlantedCrops(@RequestBody FarmCropsEntity plantedCropsRequest) {
		try {
			farmColelctorService.savePlantedCropsdata(plantedCropsRequest);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 *This method returns the planted crops against farm name
	 * @param farmName
	 * @return
	 */
	@GetMapping("/farms/{farmName}/planted-crops")
	public ResponseEntity findFarmPlantedCrops(@PathVariable String farmName) {
		try {

			return new ResponseEntity<>(farmColelctorService.getPlantedCropsByFarm(farmName), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This method returns the report for every season for each farm and each types of crops that shows expected vs actual produce
	 * @param season
	 * @return
	 */
	@GetMapping("/farms/{season}")
	public ResponseEntity findFarmReportsbySeason(@PathVariable String season) {
		try {

			return new ResponseEntity<>(farmColelctorService.getCropsBySeason(season), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 
	 * This method returns the harvested crops against farm name
	 * 
	 * @param farmName
	 * @return
	 */
	@GetMapping("/farms/{farmName}/harvested-crops")
	public ResponseEntity findFarmHarvestedCrops(@PathVariable String farmName) {
		try {

			return new ResponseEntity<>(farmColelctorService.getHarvestedCropsByFarm(farmName), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

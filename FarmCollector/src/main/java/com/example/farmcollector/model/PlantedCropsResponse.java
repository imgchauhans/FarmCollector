package com.example.farmcollector.model;



public class PlantedCropsResponse {
	
	
	
	
	
	private String farmName;
	
	
	private Double plantedArea;
	
	
	private String cropType;
	
	
	private Double expectedProduce;
	
	
	
	
	private String season;




	public Double getPlantedArea() {
		return plantedArea;
	}


	public void setPlantedArea(Double plantedArea) {
		this.plantedArea = plantedArea;
	}


	public String getCropType() {
		return cropType;
	}


	public void setCropType(String cropType) {
		this.cropType = cropType;
	}


	public Double getExpectedProduce() {
		return expectedProduce;
	}


	public void setExpectedProduce(Double expectedProduce) {
		this.expectedProduce = expectedProduce;
	}


	public String getSeason() {
		return season;
	}


	public void setSeason(String season) {
		this.season = season;
	}


	public PlantedCropsResponse( Double plantedArea, String cropType, Double expectedProduce, String season) {
		super();
		
		this.plantedArea = plantedArea;
		this.cropType = cropType;
		this.expectedProduce = expectedProduce;
		this.season = season;
	}



	public String getFarmName() {
		return farmName;
	}


	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}




	public PlantedCropsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}





	
	
	
	
}

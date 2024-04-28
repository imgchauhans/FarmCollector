package com.example.farmcollector.model;



public class HarvestedCropsResponse {
	
	
	
	
	
	private String farmName;
	
	
	private Double plantedArea;
	
	
	private String cropType;
	
	
	private Double harvestedProduce;
	
	
	
	
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






	public Double getHarvestedProduce() {
		return harvestedProduce;
	}


	public void setHarvestedProduce(Double harvestedProduce) {
		this.harvestedProduce = harvestedProduce;
	}


	public String getSeason() {
		return season;
	}


	public void setSeason(String season) {
		this.season = season;
	}






	public HarvestedCropsResponse(String farmName, Double plantedArea, String cropType, Double harvestedProduce,
			String season) {
		super();
		this.farmName = farmName;
		this.plantedArea = plantedArea;
		this.cropType = cropType;
		this.harvestedProduce = harvestedProduce;
		this.season = season;
	}


	public String getFarmName() {
		return farmName;
	}


	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}




	public HarvestedCropsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}





	
	
	
	
}

package com.example.farmcollector.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmdata")
public class FarmCropsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "farmName")
	private String farmName;

	@Column(name = "plantedArea")
	private Double plantedArea;

	@Column(name = "cropType")
	private String cropType;

	@Column(name = "expectedProduce")
	private Double expectedProduce;

	@Column(name = "harvestedProduce")
	private Double harvestedProduce;

	@Column(name = "season")
	private String season;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public FarmCropsEntity(long id, Double plantedArea, String cropType, Double expectedProduce, String season) {
		super();
		this.id = id;
		this.plantedArea = plantedArea;
		this.cropType = cropType;
		this.expectedProduce = expectedProduce;
		this.season = season;
	}

	public FarmCropsEntity(long id, String farmName, Double plantedArea, String cropType, Double expectedProduce,
			Double harvestedProduce, String season) {
		super();
		this.id = id;
		this.farmName = farmName;
		this.plantedArea = plantedArea;
		this.cropType = cropType;
		this.expectedProduce = expectedProduce;
		this.harvestedProduce = harvestedProduce;
		this.season = season;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public Double getHarvestedProduce() {
		return harvestedProduce;
	}

	public void setHarvestedProduce(Double harvestedProduce) {
		this.harvestedProduce = harvestedProduce;
	}

	public FarmCropsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PlantedCropsEntity [id=" + id + ", farmName=" + farmName + ", plantedArea=" + plantedArea
				+ ", cropType=" + cropType + ", expectedProduce=" + expectedProduce + ", harvestedProduce="
				+ harvestedProduce + ", season=" + season + "]";
	}

}

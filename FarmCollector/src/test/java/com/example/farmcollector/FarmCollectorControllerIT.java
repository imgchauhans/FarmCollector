package com.example.farmcollector;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.farmcollector.controller.FarmCollectorController;
import com.example.farmcollector.model.HarvestedCropsResponse;
import com.example.farmcollector.model.PlantedCropsResponse;
import com.example.farmcollector.repository.model.FarmCropsEntity;
import com.example.farmcollector.service.FarmCollectorService;


@WebMvcTest(FarmCollectorController.class)
public class FarmCollectorControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FarmCollectorService service;



	@Test
	public void testPlantedCropsbyFarmNameShouldReturnOK() throws Exception {
		String END_POINT_PATH = "/farms/MyFarm/planted-crops";
		PlantedCropsResponse plantedCropsResponse = new PlantedCropsResponse("MyFarm", 200.0, "corn", 10.0, "summer");

		Mockito.when(service.getPlantedCropsByFarm("MyFarm"))
				.thenReturn(Collections.singletonList(plantedCropsResponse));

		mockMvc.perform(get(END_POINT_PATH)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].season").value("summer")).andReturn();

	}

	@Test
	public void testHarvestedCropsbyFarmNameShouldReturnOK() throws Exception {
		String END_POINT_PATH = "/farms/MyFarm/harvested-crops";
		HarvestedCropsResponse harvestedCropsResponse = new HarvestedCropsResponse("MyFarm", 200.0, "potato", 5.0,
				"winter");

		Mockito.when(service.getHarvestedCropsByFarm("MyFarm"))
				.thenReturn(Collections.singletonList(harvestedCropsResponse));
		

		mockMvc.perform(get(END_POINT_PATH)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].season").value("winter")).andReturn();

	}

	@Test
	public void testrepostForEverySeason() throws Exception {
		String END_POINT_PATH = "/farms/summer";

		FarmCropsEntity farmentity = new FarmCropsEntity(1, "MyFarm", 200.0, "corn", 100.0, 50.0, "summer");

		Mockito.when(service.getCropsBySeason("summer")).thenReturn(Collections.singletonList(farmentity));

		mockMvc.perform(get(END_POINT_PATH)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].season").value("summer")).andReturn();

	}

}

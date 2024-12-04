package com.axpe.prueba;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PruebaTecnicaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test01() throws Exception {
		mockMvc.perform(get("/prices")
				.queryParam("date", "2020-06-14-10.00.00")
				.queryParam("product", "35455")
				.queryParam("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.priceList").value(1))
		.andExpect(jsonPath("$.price").value(35.50));
	}
	
	@Test
	public void test02() throws Exception {
		mockMvc.perform(get("/prices")
				.queryParam("date", "2020-06-14-16.00.00")
				.queryParam("product", "35455")
				.queryParam("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.priceList").value(2))
		.andExpect(jsonPath("$.price").value(25.45))
;
	}
	
	@Test
	public void test03() throws Exception {
		mockMvc.perform(get("/prices")
				.queryParam("date", "2020-06-14-21.00.00")
				.queryParam("product", "35455")
				.queryParam("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.priceList").value(1))
		.andExpect(jsonPath("$.price").value(35.50))
;
	}
	
	@Test
	public void test04() throws Exception {
		mockMvc.perform(get("/prices")
				.queryParam("date", "2020-06-15-10.00.00")
				.queryParam("product", "35455")
				.queryParam("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.priceList").value(3))
		.andExpect(jsonPath("$.price").value(30.50))
;
	}
	
	@Test
	public void test05() throws Exception {
		mockMvc.perform(get("/prices")
				.queryParam("date", "2020-06-16-21.00.00")
				.queryParam("product", "35455")
				.queryParam("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.priceList").value(4))
		.andExpect(jsonPath("$.price").value(38.95))
;
	}

}

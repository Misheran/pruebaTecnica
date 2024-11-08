package com.pruebatecnica.pruebatecnica;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; 


@SpringBootTest
@AutoConfigureMockMvc
class PruebatecnicaApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Test
    public void testPrice1() throws Exception {
        mockMvc.perform(get("/api/prices")
            .param("productId", "35455")
            .param("brandId", "1")
            .param("applicationDate", "2020-06-14T10:00:00"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price").value(35.50));
	}

	@Test
	public void testPrice2() throws Exception {
		mockMvc.perform(get("/api/prices")
			.param("productId", "35455")
			.param("brandId", "1")
			.param("applicationDate", "2020-06-14T16:00:00"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(25.45));
	}

	@Test
	public void testPrice3() throws Exception {
        mockMvc.perform(get("/api/prices")
            .param("productId", "35455")
            .param("brandId", "1")
            .param("applicationDate", "2020-06-14T21:00:00"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price").value(35.50));

	}

	@Test
	public void testPrice4() throws Exception {
        mockMvc.perform(get("/api/prices")
            .param("productId", "35455")
            .param("brandId", "1")
            .param("applicationDate", "2020-06-15T10:00:00"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price").value(30.50));
	}

	@Test
	public void testPrice5() throws Exception {
        mockMvc.perform(get("/api/prices")
            .param("productId", "35455")
            .param("brandId", "1")
            .param("applicationDate", "2020-06-16T21:00:00"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price").value(38.95));
	}

    @Test
	public void testPrice6() throws Exception {
        mockMvc.perform(get("/api/prices")
            .param("productId", "35455")
            .param("brandId", "1")
            .param("applicationDate", "2021-12-31T21:00:00"))
            .andExpect(status().isNotFound());
	}
}


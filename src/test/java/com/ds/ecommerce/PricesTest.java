package com.ds.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource("/application-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
public class PricesTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${sql.script.get.firsttest}")
    private String firstTest;

    @Value("${sql.script.get.secondtest}")
    private String secondTest;

    @Value("${sql.script.get.thirdtest}")
    private String thirdTest;

    @Value("${sql.script.get.fourthtest}")
    private String fourthTest;

    @Value("${sql.script.get.fifthtest}")
    private String fifthTest;

    // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void getPriceHttpRequest_Test_1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(firstTest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.BRAND_ID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.START_DATE").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.END_DATE").value("2020-06-14T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE_LIST").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.CURR").value("EUR"));

    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void getPriceHttpRequest_Test_2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(secondTest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.BRAND_ID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.START_DATE").value("2020-06-14T15:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.END_DATE").value("2020-06-14T18:30:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE_LIST").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value(25.45))
                .andExpect(MockMvcResultMatchers.jsonPath("$.CURR").value("EUR"));

    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void getPriceHttpRequest_Test_3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(thirdTest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.BRAND_ID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.START_DATE").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.END_DATE").value("2020-06-14T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE_LIST").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.CURR").value("EUR"));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    void getPriceHttpRequest_Test_4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(fourthTest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.BRAND_ID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.START_DATE").value("2020-06-15T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.END_DATE").value("2020-06-15T11:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE_LIST").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value(30.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.CURR").value("EUR"));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    void getPriceHttpRequest_Test_5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(fifthTest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.BRAND_ID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.START_DATE").value("2020-06-15T16:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.END_DATE").value("2020-12-31T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE_LIST").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value(38.95))
                .andExpect(MockMvcResultMatchers.jsonPath("$.CURR").value("EUR"));
    }
}
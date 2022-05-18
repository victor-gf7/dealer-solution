package com.exercise.dealersolution.applicartion.controller;

import com.exercise.dealersolution.adapters.service.ProductService;
import com.exercise.dealersolution.applicartion.controller.dto.ProductResponse;
import com.exercise.dealersolution.core.entities.Product;
import com.exercise.util.ProductBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;


import static com.exercise.dealersolution.core.enums.StatusEnum.NEW;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Should return a list containing all products in stock")
    void test01() throws Exception {

        List<Product> expected = getProducts();

        Mockito.when(productService.retrieveAllProducts()).thenReturn(expected);

        MvcResult result = mockMvc.perform(
                get("/api/dealer/products")
                .accept(APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


        List<ProductResponse> actual = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<ProductResponse>>() {});

        assertEquals(expected.stream().map(ProductResponse::of).collect(Collectors.toList()), actual);
    }

    private List<Product> getProducts() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return Arrays.asList(new ProductBuilder()
                .withId(1L)
                .withDescription("SUV")
                .withPrice(new BigDecimal("100.000"))
                .withQuantity(100)
                .withStatus(NEW)
                .withDeadline(dateFormat.parse("28/07/2022"))
                .create(), new ProductBuilder()
                .withId(2L)
                .withDescription("Sport")
                .withPrice(new BigDecimal("200.000"))
                .withQuantity(33)
                .withStatus(NEW)
                .withDeadline(dateFormat.parse("01/06/2022"))
                .create());
    }

}
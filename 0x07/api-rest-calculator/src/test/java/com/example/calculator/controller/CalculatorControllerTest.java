package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers?number1=" + 12.0 + "&number2=" + 13.0);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("25.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        RequestBuilder request = get("/calculator/subNumbers?number1=" + 12.0 + "&number2=" + 2.0);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("10.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers?number1=" + 12.0 + "&number2=" + 2.0);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("6.0", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        RequestBuilder request = get("/calculator/factorial?factorial=" + 5);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("120", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        RequestBuilder request = get("/calculator/calculeDayBetweenDate?localDate1=" + "2022-04-05" + "&localDate2=" + "2022-04-10");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        RequestBuilder request = get("/calculator/integerToBinary?number1=" + 20);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("10100", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        RequestBuilder request = get("/calculator/integerToHexadecimal?number1=" + 170);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("AA", result.getResponse().getContentAsString().toUpperCase());
    }

}

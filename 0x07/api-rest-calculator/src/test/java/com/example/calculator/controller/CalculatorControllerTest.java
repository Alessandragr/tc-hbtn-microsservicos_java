package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Calculator calculator;

    @BeforeEach
    public void setuptest() {
        standaloneSetup(this.mvc);
    }

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        Mockito.when(this.calculator.sum(2.0, 4.0)).thenReturn(6.0);
        RequestBuilder requestBuilder = get("/calculator/addNumbers").param("number1", "2.0").param("number2", "4.0");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertEquals("6.0", mvcResult.getResponse().getContentAsString());
    }
    @Test
    void subNumbers() throws Exception {
        Mockito.when(this.calculator.sub(4.0, 2.0)).thenReturn(2.0);
        RequestBuilder requestBuilder = get("/calculator/subNumbers").param("number1", "4.0").param("number2", "2.0");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertEquals("2.0", mvcResult.getResponse().getContentAsString());
    }
    @Test
    void divideNumbers() throws Exception {
        Mockito.when(this.calculator.divide(4.0, 2.0)).thenReturn(2.0);
        RequestBuilder requestBuilder = get("/calculator/divideNumbers").param("number1", "4.0").param("number2", "2.0");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertEquals("2.0", mvcResult.getResponse().getContentAsString());
    }
    @Test
    void factorial() throws Exception {
        Mockito.when(this.calculator.factorial(4)).thenReturn(24);
        RequestBuilder requestBuilder = get("/calculator/factorial").param("factorial", "4");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertEquals("24", mvcResult.getResponse().getContentAsString());
    }
    @Test
    void calculeDayBetweenDate() throws Exception {
        Mockito.when(this.calculator.calculeDayBetweenDate(LocalDate.of(2020, 3, 15), LocalDate.of(2020, 3, 29))).thenReturn(15);
        RequestBuilder requestBuilder = get("/calculator/calculeDayBetweenDate").param("localDate1", "2022-09-15").param("localDate2", "2022-09-30");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        assertEquals("14", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        Mockito.when(this.calculator.integerToBinary(1)).thenReturn(String.valueOf(1));
        RequestBuilder requestBuilder = get("/calculator/integerToBinary").param("number1", "1");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        assertEquals("1", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        Mockito.when(this.calculator.integerToHexadecimal(1)).thenReturn("1");
        RequestBuilder requestBuilder = get("/calculator/integerToHexadecimal").param("number1", "1");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        assertEquals("1", result.getResponse().getContentAsString());
    }


}
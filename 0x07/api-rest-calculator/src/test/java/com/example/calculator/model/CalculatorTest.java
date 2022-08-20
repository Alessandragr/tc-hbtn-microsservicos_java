package com.example.calculator.model;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @BeforeEach
    public void setuptest() {
        standaloneSetup(this.mvc);
    }

    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.sum(8.0, 2.0));
    }

    @Test
    public void numbersNullSumTest() {
        String messageFromException = "";
        try{
            Calculator calculator = new Calculator();
            calculator.sum(null, null);
        } catch (RuntimeException e) {
            messageFromException = e.getMessage();
        }
        assertEquals("Número 1 e número 2 são obrigatórios.", messageFromException);
    }

    @Test
    void subTest() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.sub(8.0, 2.0));
    }

    @Test
    void divideTest() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.divide(8.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        String messageFromException = "";
        try{
            Calculator calculator = new Calculator();
            calculator.divide(4.0, 0.0);
        } catch (ArithmeticException e) {
            messageFromException = e.getMessage();
        }
        assertEquals("Divisão por zero não é permitido.", messageFromException);
    }

    @Test
    void factorialTest() {
        Calculator calculator = new Calculator();

        assertEquals(24, calculator.factorial(4));
    }

    @Test
    void integerToBinaryTest() {
        Calculator calculator = new Calculator();

        assertEquals("1", calculator.integerToBinary(1));
        assertEquals("101", calculator.integerToBinary(5));
    }

    @Test
    void integerToHexadecimalTest() {
        Calculator calculator = new Calculator();
        Calculator calculator1 = new Calculator();

        assertEquals("1", calculator.integerToHexadecimal(1));
    }

    @Test
    void calculeDayBetweenDateTest() {
        Calculator calculator = new Calculator();
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);

        assertEquals(14, calculator.calculeDayBetweenDate(date1, date2));
    }
}

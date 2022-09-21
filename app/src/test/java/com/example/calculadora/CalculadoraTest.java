package com.example.calculadora;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    Calculadora calculadora;

    @Before
    public void setup() {
        calculadora = new Calculadora();
    }

    @Test
    public void opera() {
        calculadora.setOper1(1);
        calculadora.setOper2(2);
        calculadora.setOperacion(Calculadora.OPERACION.SUMA);
        double opera = calculadora.opera();
        assertEquals(opera, 3, 0.001);
    }

    @Test
    public void isNumeric() {
        assertTrue(Calculadora.isNumeric("5"));

        assertFalse(Calculadora.isNumeric("a"));
    }
}
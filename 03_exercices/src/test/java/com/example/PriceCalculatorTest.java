package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceCalculatorTest {

    @Test
    void shouldCalculateTotalPrice() {
        PriceCalculator calculator = new PriceCalculator();

        double result = calculator.calculateTotalPrice(10.0, 3);

        assertEquals(30.0, result);
    }

    @Test
    void shouldApplyDiscount() {
        PriceCalculator calculator = new PriceCalculator();

        double result = calculator.applyDiscount(100.0, 0.20);

        assertEquals(80.0, result);
    }

    @Test
    void shouldCalculateVat() {
        PriceCalculator calculator = new PriceCalculator();

        double result = calculator.calculateVat(100.0, 0.20);

        assertEquals(20.0, result);
    }

    @Test
    void shouldCalculatePriceWithVat() {
        PriceCalculator calculator = new PriceCalculator();

        double result = calculator.calculatePriceWithVat(100.0, 0.20);

        assertEquals(120.0, result);
    }

    @Test
    void shouldThrowWhenUnitPriceIsNegative() {
        PriceCalculator calculator = new PriceCalculator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotalPrice(-1.0, 1)
        );

        assertEquals("Le prix unitaire ne doit pas être négatif.", exception.getMessage());
    }

    @Test
    void shouldThrowWhenQuantityIsNegative() {
        PriceCalculator calculator = new PriceCalculator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotalPrice(10.0, -1)
        );

        assertEquals("La quantité ne doit pas être négative.", exception.getMessage());
    }

    @Test
    void shouldThrowWhenDiscountRateIsNegative() {
        PriceCalculator calculator = new PriceCalculator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.applyDiscount(100.0, -0.1)
        );

        assertEquals("Le taux de remise ne doit pas être négatif.", exception.getMessage());
    }

    @Test
    void shouldThrowWhenVatRateIsNegative() {
        PriceCalculator calculator = new PriceCalculator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateVat(100.0, -0.1)
        );

        assertEquals("Le taux de TVA ne doit pas être négatif.", exception.getMessage());
    }
}

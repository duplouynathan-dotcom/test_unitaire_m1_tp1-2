package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceCalculatorTest {

    private final PriceCalculator calculator = new PriceCalculator();

    @Test
    void shouldCalculateTotalPrice() {
        assertEquals(30.0, calculator.calculateTotalPrice(10.0, 3));
    }

    @Test
    void shouldApplyDiscount() {
        assertEquals(80.0, calculator.applyDiscount(100.0, 0.20));
    }

    @Test
    void shouldCalculateVat() {
        assertEquals(20.0, calculator.calculateVat(100.0, 0.20));
    }

    @Test
    void shouldCalculatePriceWithVat() {
        assertEquals(120.0, calculator.calculatePriceWithVat(100.0, 0.20));
    }

    @Test
    void shouldThrowWhenUnitPriceIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotalPrice(-1.0, 1)
        );
    }

    @Test
    void shouldThrowWhenQuantityIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotalPrice(10.0, -1)
        );
    }

    @Test
    void shouldThrowWhenDiscountRateIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.applyDiscount(100.0, -0.1)
        );
    }

    @Test
    void shouldThrowWhenVatRateIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateVat(100.0, -0.1)
        );
    }

    @Test
    void shouldThrowWhenVatRateIsNegativeInCalculatePriceWithVat() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculatePriceWithVat(100.0, -0.1)
        );
    }
}

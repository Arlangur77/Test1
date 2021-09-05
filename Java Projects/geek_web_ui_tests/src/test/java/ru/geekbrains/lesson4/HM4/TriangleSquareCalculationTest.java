package ru.geekbrains.lesson4.HM4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TriangleSquareCalculationTest {

    private static double countTriangleArea(double sideA, double sideB, double sideC) throws BadTriangleException {
        //вырожденный
        if (sideA < 0 || sideB < 0 || sideC < 0) throw new BadTriangleException();
        double halfP = (sideA + sideB + sideC) / 2;
        double square = Math.sqrt(halfP * (halfP - sideA) * (halfP - sideB) * (halfP - sideC));
        return square;
    }

    @Test
    void calcArea() throws BadTriangleException {
        double result = countTriangleArea(2, 2, 2);
        Assertions.assertEquals(1.7320508075688772, result);
    }

    @Test
    void badTriangleTest() {
        assertThatExceptionOfType(BadTriangleException.class).isThrownBy(
                () -> countTriangleArea(-1, 1, 1));
    }
}

package me.sontag.codetest;

import me.sontag.codetest.utils.MathUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  Tests for methods in the MathUtil class
 */
@SpringBootTest
public class MathUtilTest {
    private static final double DELTA = 1e-12;

    /**
     *  Test for the implemented power method
     */
    @Test
    void testPow() {
        double a = MathUtil.pow(1.05, 5);
        double b = MathUtil.pow(0.0, 25);
        double c = MathUtil.pow(2, 2);
        double d = MathUtil.pow(0.5, 2);

        assertEquals(1.2762815625, a, DELTA);
        assertEquals(0.0, b, DELTA);
        assertEquals(4.0, c, DELTA);
        assertEquals(0.25, d, DELTA);
    }

    /**
     *  Test for monthly payment calculation
     */
    @Test
    void testPaymentCalculation() {
        double a = MathUtil.calculateMonthlyPayment(0.05, 1000.0, 24);
        double b = MathUtil.calculateMonthlyPayment(0.0127, 4356.0, 72);

        assertEquals(72.47090075268697, a, DELTA);
        assertEquals(92.67636698267995, b, DELTA);
    }

}

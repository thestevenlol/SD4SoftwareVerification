package cm;


import org.junit.jupiter.api.Test;
import src.Period;
import src.Rate;
import src.enums.CarParkKind;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoleyJackTestTask1 {

    final Random random = new Random();

    @Test
    void TestRateAttributesNotNull() {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(2), new BigDecimal(1));
        assertNotNull(rate.getHourlyNormalRate());
        assertNotNull(rate.getHourlyReducedRate());
    }

    @Test
    void TestRateAttributesNotNullRandom() {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(random.nextInt()), new BigDecimal(random.nextInt()));
        assertNotNull(rate.getHourlyNormalRate());
        assertNotNull(rate.getHourlyReducedRate());
    }

    @Test
    void TestRateCalculation() {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(2), new BigDecimal(1));
        Period period = new Period(8, 16);
        BigDecimal cost = rate.calculate(period);
        assertNotNull(cost);
        assertTrue(cost.compareTo(BigDecimal.ZERO) >= 0);
    }

}

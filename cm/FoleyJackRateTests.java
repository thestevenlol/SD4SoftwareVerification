package cm;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Tag("cmTask1")
public class FoleyJackRateTests {

    /*
     *
     * Created by Jack Foley
     * C00274246
     * October 24th, 2024
     *
     */

    /*

    @Test
    public void testRateValidKind() {
        CarParkKind kind = CarParkKind.STAFF;
        Rate rate = new Rate(kind, BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        assertNotNull(rate);
        assertEquals(kind, rate.getKind());
    }

    @Test
    public void testRateValidHourlyNormalRate() {
        BigDecimal hourlyNormalRate = BigDecimal.valueOf(5);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, BigDecimal.valueOf(3));
        assertNotNull(rate);
        assertEquals(hourlyNormalRate, rate.getHourlyNormalRate());
    }

    @Test
    public void testRateValidHourlyReducedRate() {
        BigDecimal hourlyReducedRate = BigDecimal.valueOf(3);
        Rate rate = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), hourlyReducedRate);
        assertNotNull(rate);
        assertEquals(hourlyReducedRate, rate.getHourlyReducedRate());
    }

    @Test
    public void testRateValidBoundaryHourlyNormalRate() {
        BigDecimal hourlyNormalRate = BigDecimal.valueOf(1);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, BigDecimal.valueOf(1));
        assertNotNull(rate);
        assertEquals(hourlyNormalRate, rate.getHourlyNormalRate());
    }

    @Test
    public void testRateValidBoundaryHourlyReducedRate() {
        BigDecimal hourlyReducedRate = BigDecimal.valueOf(1);
        Rate rate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(8), hourlyReducedRate);
        assertNotNull(rate);
        assertEquals(hourlyReducedRate, rate.getHourlyReducedRate());
    }

    @Test
    public void testRateInvalidBoundaryHourlyNormalRate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(0), BigDecimal.valueOf(2));
        });
    }

    @Test
    public void testRateInvalidBoundaryHourlyReducedRate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(0));
        });
    }

    @Test
    public void testRateInvalidKind() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(null, BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        });
    }

    @Test
    public void testRateInvalidHourlyNormalRateNonNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(-1), BigDecimal.valueOf(3));
        });
    }

    @Test
    public void testRateInvalidHourlyReducedRateNonNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(-1));
        });
    }

    @Test
    public void testRateInvalidHourlyNormalRateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, null, BigDecimal.valueOf(3));
        });
    }

    @Test
    public void testRateInvalidHourlyReducedRateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), null);
        });
    }

    @Test
    public void testRateValidCalculate() {
        Rate rate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        Period period = new Period(2, 3);
        BigDecimal expected = BigDecimal.valueOf(5);
        assertEquals(expected, rate.calculate(period));
    }

    */

}

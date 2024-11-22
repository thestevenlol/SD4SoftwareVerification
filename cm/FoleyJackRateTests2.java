package cm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Tag("cmTask2")
public class FoleyJackRateTests2 {

    /*
     *
     * Created by Jack Foley
     * C00274246
     * October 24th, 2024
     *
     */

    private ArrayList<Period> reducedPeriods;
    private ArrayList<Period> normalPeriods;
    private BigDecimal normalRate;
    private BigDecimal reducedRate;

    @BeforeEach
    void setup() {
        reducedPeriods = new ArrayList<>();
        normalPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(8, 12));
        normalPeriods.add(new Period(12, 18));
        normalRate = new BigDecimal("10.00");
        reducedRate = new BigDecimal("5.00");
    }

    @Test
    void constructor_validParameters_shouldCreateInstance() {
        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }

    @Test
    void constructor_nullReducedPeriods_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, null, normalPeriods, normalRate, reducedRate));
    }

    @Test
    void constructor_nullNormalPeriods_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, reducedPeriods, null, normalRate, reducedRate));
    }

    @Test
    void constructor_invalidNormalPeriods_shouldThrowException() {
        normalPeriods.clear();
        normalPeriods.add(new Period(5,10));
        normalPeriods.add(new Period(6,11));
        normalPeriods.add(new Period(7,12));

        reducedPeriods.clear();
        reducedPeriods.add(new Period(18,20));

        normalRate = new BigDecimal("12.00");
        reducedRate = new BigDecimal("5.00");

        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.MANAGEMENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
    }

    @Test
    void constructor_nullRates_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, null, reducedRate));
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, null));
    }

    @Test
    void constructor_negativeRates_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, new BigDecimal("-10.00"), reducedRate));
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, new BigDecimal("-5.00")));
    }

    @Test
    void constructor_normalRateLessThanOrEqualReducedRate_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, new BigDecimal("5.00"), new BigDecimal("5.00")));
    }

    @Test
    void constructor_overlappingPeriods_shouldThrowException() {
        reducedPeriods.add(new Period(10, 14));
        assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate));
    }

    @Test
    void calculate_noOverlap_shouldCalculateCorrectly() {
        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period stayPeriod = new Period(8, 18); // Covers both reduced and normal rates
        BigDecimal result = rate.calculate(stayPeriod);
        BigDecimal expected = normalRate.multiply(BigDecimal.valueOf(6)) // 6 hours normal
                .add(reducedRate.multiply(BigDecimal.valueOf(4)));      // 4 hours reduced
        assertEquals(expected, result);
    }

    @Test
    void calculate_visitorKind_shouldReturnZero() {
        Rate rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period stayPeriod = new Period(8, 18);
        BigDecimal result = rate.calculate(stayPeriod);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void calculate_partialOverlap_shouldCalculateCorrectly() {
        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period stayPeriod = new Period(10, 14); // Partially in reduced and normal
        BigDecimal result = rate.calculate(stayPeriod);
        BigDecimal expected = reducedRate.multiply(BigDecimal.valueOf(2)) // 2 hours reduced
                .add(normalRate.multiply(BigDecimal.valueOf(2)));        // 2 hours normal
        assertEquals(expected, result);
    }

    @Test
    void calculate_noValidPeriods_shouldReturnZero() {
        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period stayPeriod = new Period(18, 20); // Outside all defined periods
        BigDecimal result = rate.calculate(stayPeriod);
        assertEquals(0, result.compareTo(BigDecimal.ZERO)); // Compare values without considering scale
    }

}

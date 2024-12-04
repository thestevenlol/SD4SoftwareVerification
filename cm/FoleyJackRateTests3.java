package cm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Tag("cmTask3")
public class FoleyJackRateTests3 {

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

//    @Test
//    void constructor_validParameters_shouldCreateInstance() {
//        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
//        assertNotNull(rate);
//    }
//
//    @Test
//    void constructor_nullReducedPeriods_shouldThrowException() {
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, null, normalPeriods, normalRate, reducedRate));
//    }
//
//    @Test
//    void constructor_nullNormalPeriods_shouldThrowException() {
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, reducedPeriods, null, normalRate, reducedRate));
//    }
//
//    @Test
//    void constructor_invalidNormalPeriods_shouldThrowException() {
//        normalPeriods.clear();
//        normalPeriods.add(new Period(5,10));
//        normalPeriods.add(new Period(6,11));
//        normalPeriods.add(new Period(7,12));
//
//        reducedPeriods.clear();
//        reducedPeriods.add(new Period(18,20));
//
//        normalRate = new BigDecimal("12.00");
//        reducedRate = new BigDecimal("5.00");
//
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.MANAGEMENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
//    }
//
//    @Test
//    void constructor_nullRates_shouldThrowException() {
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, null, reducedRate));
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, null));
//    }
//
//    @Test
//    void constructor_negativeRates_shouldThrowException() {
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, new BigDecimal("-10.00"), reducedRate));
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, new BigDecimal("-5.00")));
//    }
//
//    @Test
//    void constructor_normalRateLessThanOrEqualReducedRate_shouldThrowException() {
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, new BigDecimal("5.00"), new BigDecimal("5.00")));
//    }
//
//    @Test
//    void constructor_overlappingPeriods_shouldThrowException() {
//        reducedPeriods.add(new Period(10, 14));
//        assertThrows(IllegalArgumentException.class, () ->
//                new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate));
//    }
//
//    @Test
//    void calculate_noOverlap_shouldCalculateCorrectly() {
//        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
//        Period stayPeriod = new Period(8, 18); // Covers both reduced and normal rates
//        BigDecimal result = rate.calculate(stayPeriod);
//        BigDecimal expected = normalRate.multiply(BigDecimal.valueOf(6)) // 6 hours normal
//                .add(reducedRate.multiply(BigDecimal.valueOf(4)));      // 4 hours reduced
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void calculate_visitorKind_shouldReturnZero() {
//        Rate rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);
//        Period stayPeriod = new Period(8, 18);
//        BigDecimal result = rate.calculate(stayPeriod);
//        assertEquals(BigDecimal.ZERO, result);
//    }
//
//    @Test
//    void calculate_partialOverlap_shouldCalculateCorrectly() {
//        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
//        Period stayPeriod = new Period(10, 14); // Partially in reduced and normal
//        BigDecimal result = rate.calculate(stayPeriod);
//        BigDecimal expected = reducedRate.multiply(BigDecimal.valueOf(2)) // 2 hours reduced
//                .add(normalRate.multiply(BigDecimal.valueOf(2)));        // 2 hours normal
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void calculate_noValidPeriods_shouldReturnZero() {
//        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
//        Period stayPeriod = new Period(18, 20); // Outside all defined periods
//        BigDecimal result = rate.calculate(stayPeriod);
//        assertEquals(0, result.compareTo(BigDecimal.ZERO)); // Compare values without considering scale
//    }

    @Test
    public void calculate_returnsZero_whenVisitorRateBelowTen() {
        Rate rate = createRate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        Period periodStay = new Period(9, 11); // 2 hours total cost is 2 * 5 = 10
        BigDecimal result = rate.calculate(periodStay);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void calculate_returnsHalfOfAmountAboveTen_whenVisitorRateAboveTen() {
        Rate rate = createRate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        Period periodStay = new Period(9, 13); // 4 hours total cost is 4 * 5 = 20, above 10
        BigDecimal result = rate.calculate(periodStay);
        assertEquals(BigDecimal.valueOf(5.0).setScale(1, BigDecimal.ROUND_HALF_UP), result.setScale(1, BigDecimal.ROUND_HALF_UP)); // (20 - 10) * 0.5 = 5.0
    }

    @Test
    public void calculate_returnsMinimumPayable_whenManagementBelowMinimum() {
        Rate rate = createRate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(2), BigDecimal.valueOf(1));
        Period periodStay = new Period(9, 10); // 1 hour cost is 1 * 2 = 2, below minimum
        BigDecimal result = rate.calculate(periodStay);
        assertEquals(BigDecimal.valueOf(4), result); // Minimum payable is 4
    }

    @Test
    public void calculate_returnsTotalCost_whenManagementAboveMinimum() {
        Rate rate = createRate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        Period periodStay = new Period(9, 12); // 3 hours total cost is 3 * 5 = 15, above minimum
        BigDecimal result = rate.calculate(periodStay);
        assertEquals(BigDecimal.valueOf(15), result);
    }

    @Test
    public void calculate_appliesStudentReductionAboveFivePointFive_whenCostAboveThreshold() {
        Rate rate = createRate(CarParkKind.STUDENT, BigDecimal.valueOf(4), BigDecimal.valueOf(3));
        Period periodStay = new Period(9, 14); // 5 hours total cost is 5 * 4 = 20, above 5.5
        BigDecimal result = rate.calculate(periodStay);
        BigDecimal expected = BigDecimal.valueOf(5.5).add(BigDecimal.valueOf((20 - 5.5) * 0.75));
        assertEquals(expected.setScale(2, BigDecimal.ROUND_HALF_UP), result.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void calculate_returnsTotalCost_whenStudentBelowReductionThreshold() {
        Rate rate = createRate(CarParkKind.STUDENT, BigDecimal.valueOf(4), BigDecimal.valueOf(3));
        Period periodStay = new Period(9, 10); // 1 hour cost is 1 * 4 = 4, below 5.5
        BigDecimal result = rate.calculate(periodStay);
        assertEquals(BigDecimal.valueOf(4), result);
    }

    @Test
    public void calculate_returnsMaximumPayable_whenStaffAboveMaximum() {
        Rate rate = createRate(CarParkKind.STAFF, BigDecimal.valueOf(11), BigDecimal.valueOf(10));
        Period periodStay = new Period(9, 11); // 2 hours total cost is 2 * 11 = 22, above max
        BigDecimal result = rate.calculate(periodStay);
        assertEquals(BigDecimal.valueOf(16), result); // Maximum payable is 16
    }

    @Test
    public void calculate_returnsTotalCost_whenStaffBelowMaximum() {
        Rate rate = createRate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        Period periodStay = new Period(9, 11); // 2 hours total cost is 2 * 5 = 10, below max
        BigDecimal result = rate.calculate(periodStay);
        assertEquals(BigDecimal.valueOf(10), result);
    }

    private Rate createRate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate) {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17)); // Normal hours from 9 to 17
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24)); // Reduced hours from 17 to 24
        return new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
    }

}

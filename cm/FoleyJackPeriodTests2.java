package cm;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import cm.Period;

Decimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("cmTask2")
public class FoleyJackPeriodTests2 {

    /*
    *
    * Created by Jack Foley
    * C00274246
    * October 23rd, 2024
    *
    */

    // Test Class for Period

//    Tests removed as it seems that in the Period class there is no implementation for the startHour and endHour getters.

//    @Test
//    public void testPeriodValidStartHour() {
//        final int startHour = 19;
//        final int endHour = 3;
//        Period period = new Period(startHour, endHour);
//        assertNotNull(period);
//        assertEquals(startHour, period.getStartHour());
//    }
//
//    @Test
//    public void testPeriodValidEndHour() {
//        final int startHour = 2;
//        final int endHour = 3;
//        Period period = new Period(startHour, endHour);
//        assertNotNull(period);
//        assertEquals(endHour, period.getEndHour());
//    }
//
//    @Test
//    public void testPeriodInvalidStartHour() {
//        final int startHour = -1;
//        final int endHour = 3;
//        assertThrows(IllegalArgumentException.class, () -> new Period(startHour, endHour));
//    }
//
//    @Test
//    public void testPeriodInvalidEndHour() {
//        final int startHour = 2;
//        final int endHour = 25;
//        assertThrows(IllegalArgumentException.class, () -> new Period(startHour, endHour));
//    }
//
//    @Test
//    public void testPeriodOverlaps() {
//        final int startHour1 = 2;
//        final int endHour1 = 5;
//        final int startHour2 = 3;
//        final int endHour2 = 4;
//        Period period1 = new Period(startHour1, endHour1);
//        Period period2 = new Period(startHour2, endHour2);
//        assertTrue(period1.overlaps(period2));
//    }
//
//    @Test
//    public void testPeriodNoOverlaps() {
//        final int startHour1 = 2;
//        final int endHour1 = 3;
//        final int startHour2 = 4;
//        final int endHour2 = 5;
//        Period period1 = new Period(startHour1, endHour1);
//        Period period2 = new Period(startHour2, endHour2);
//        assertFalse(period1.overlaps(period2));
//    }
//
//    @Test
//    public void testPeriodInvalidOverlaps() {
//        final int startHour1 = 0;
//        final int endHour1 = 0;
//        final int startHour2 = 0;
//        final int endHour2 = 0;
//        Period period1 = new Period(startHour1, endHour1);
//        Period period2 = new Period(startHour2, endHour2);
//        assertThrows(IllegalArgumentException.class, () -> period1.overlaps(period2));
//    }
//
//    @Test
//    public void testPeriodValidBoundaryStartHour() {
//        final int startHour = 0;
//        final int endHour = 3;
//        Period period = new Period(startHour, endHour);
//        assertNotNull(period);
//        assertEquals(startHour, period.getStartHour());
//    }
//
//    @Test
//    public void testPeriodInvalidBoundaryStartHour() {
//        final int startHour = -1;
//        final int endHour = 3;
//        assertThrows(IllegalArgumentException.class, () -> new Period(startHour, endHour));
//    }
//
//    @Test
//    public void testPeriodValidBoundaryEndHour() {
//        final int startHour = 2;
//        final int endHour = 23;
//        Period period = new Period(startHour, endHour);
//        assertNotNull(period);
//        assertEquals(endHour, period.getEndHour());
//    }
//
//    @Test
//    public void testPeriodInvalidBoundaryEndHour() {
//        final int startHour = 2;
//        final int endHour = 24;
//        assertThrows(IllegalArgumentException.class, () -> new Period(startHour, endHour));
//    }

    @Test
    void constructor_startEqualsEnd_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Period(10, 10));
        assertEquals("start of period cannot be later or equal to end of period", exception.getMessage());
    }

    @Test
    void constructor_startBiggerThanMax_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Period(25, 26));
        assertEquals("start of period and end of period must be between 0 and 24", exception.getMessage());
    }

    @Test
    void constructor_startSmallerThanMin_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Period(-1, 0));
        assertEquals("start of period and end of period must be between 0 and 24", exception.getMessage());
    }

    // This test will never actually get to check if end is less than 0 since it will always check start first,
    // and since the source code for Period requires that start < end, it will never actually reach the end condition check.
    @Test
    void constructor_endSmallerThanMin_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Period(-2, -1));
        assertEquals("start of period and end of period must be between 0 and 24", exception.getMessage());
    }

    @Test
    void constructor_startAfterEnd_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Period(12, 10));
        assertEquals("start of period cannot be later or equal to end of period", exception.getMessage());
    }

    @Test
    void constructor_startOutOfBounds_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Period(-1, 10));
        assertEquals("start of period and end of period must be between 0 and 24", exception.getMessage());
    }

    @Test
    void constructor_endOutOfBounds_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Period(10, 25));
        assertEquals("start of period and end of period must be between 0 and 24", exception.getMessage());
    }

    @Test
    public void constructor_overlappingPeriods_shouldThrowException() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        // Add overlapping periods
        reducedPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(11, 14));

        BigDecimal normalRate = new BigDecimal("10.00");
        BigDecimal reducedRate = new BigDecimal("5.00");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });
    }

    @Test
    void duration_givenValidPeriod_shouldReturnCorrectDuration() {
        Period period = new Period(5, 9);
        assertEquals(4, period.duration(), "Duration should be 4 hours for period 5-9");
    }

    @Test
    void overlaps_givenOverlappingPeriods_shouldReturnTrue() {
        Period period1 = new Period(9, 12);
        Period period2 = new Period(11, 14);
        assertTrue(period1.overlaps(period2), "Periods 9-12 and 11-14 should overlap");
    }

    @Test
    void overlaps_givenNonOverlappingPeriods_shouldReturnFalse() {
        Period period1 = new Period(9, 12);
        Period period2 = new Period(13, 15);
        assertFalse(period1.overlaps(period2), "Periods 9-12 and 13-15 should not overlap");
    }

    @Test
    void overlaps_givenTouchingPeriods_shouldReturnFalse() {
        Period period1 = new Period(9, 12);
        Period period2 = new Period(12, 15);
        assertFalse(period1.overlaps(period2), "Periods 9-12 and 12-15 should not overlap when they just touch");
    }

    @Test
    void occurences_givenOverlappingPeriods_shouldReturnCorrectCount() {
        Period period1 = new Period(9, 12);
        List<Period> list = Arrays.asList(new Period(8, 10), new Period(10, 14));
        assertEquals(3, period1.occurences(list), "Period 9-12 should occur in two hours of the provided list");
    }

    @Test
    void occurences_givenNoOverlappingPeriods_shouldReturnZero() {
        Period period1 = new Period(15, 17);
        List<Period> list = Arrays.asList(new Period(8, 10), new Period(10, 14));
        assertEquals(0, period1.occurences(list), "Period 15-17 should not occur in any hours of the provided list");
    }

}

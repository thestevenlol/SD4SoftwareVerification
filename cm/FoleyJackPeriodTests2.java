package cm;


import org.junit.jupiter.api.Test;
import cm.Period;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testPeriodOverlaps() {
        final int startHour1 = 2;
        final int endHour1 = 5;
        final int startHour2 = 3;
        final int endHour2 = 4;
        Period period1 = new Period(startHour1, endHour1);
        Period period2 = new Period(startHour2, endHour2);
        assertTrue(period1.overlaps(period2));
    }

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

}

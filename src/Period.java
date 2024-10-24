package src;

public class Period {
    private int startHour;
    private int endHour;

    // Constructor
    public Period(int startHour, int endHour) {

        if (startHour < 0 || startHour > 23 || endHour < 0 || endHour > 23) {
            throw new IllegalArgumentException("Invalid start or end hour");
        }

        this.startHour = startHour;
        this.endHour = endHour;
    }

    // Method to calculate duration of the period
    public int duration() {

        if (this.startHour == 0 && this.endHour == 0) {
            return 0;
        }

        if (this.startHour == this.endHour) {
            return 0;
        }

        if (this.startHour > this.endHour) {
            return 24 - startHour + endHour;
        }

        return endHour - startHour;
    }

    // Method to check if two periods overlap
    public boolean overlaps(Period otherPeriod) {

        if (this.startHour == 0 && this.endHour == 0 && otherPeriod.startHour == 0 && otherPeriod.endHour == 0) {
            throw new IllegalArgumentException();
        }

        return this.startHour < otherPeriod.endHour && otherPeriod.startHour < this.endHour;
    }

    // Getters and Setters
    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
}

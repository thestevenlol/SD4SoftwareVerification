package src;

public class Period {
    private int startHour;
    private int endHour;

    // Constructor
    public Period(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    // Method to calculate duration of the period
    public int duration() {
        return endHour - startHour;
    }

    // Method to check if two periods overlap
    public boolean overlaps(Period otherPeriod) {
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

package src;

import java.util.Date;

public class Stay {
    private Date entryDateTime;
    private Date exitDateTime;
    private double charge;
    private Driver driver;

    // Constructor
    public Stay(Date entryDateTime, Driver driver) {
        this.entryDateTime = entryDateTime;
        this.driver = driver;
    }

    // Getters and Setters
    public Date getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(Date entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Date getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(Date exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

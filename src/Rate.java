package src;

import src.enums.CarParkKind;

import java.math.BigDecimal;

public class Rate {

    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;

    // Constructor
    public Rate(CarParkKind kind, BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate) {

//        null checks for each arg
        if (kind == null) {
            throw new IllegalArgumentException("Car park kind cannot be null");
        }

        if (hourlyNormalRate == null) {
            throw new IllegalArgumentException("Hourly normal rate cannot be null");
        }

        if (hourlyReducedRate == null) {
            throw new IllegalArgumentException("Hourly reduced rate cannot be null");
        }

//        check for negative or zero values

        if (hourlyNormalRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Hourly normal rate cannot be negative or zero");
        }

        if (hourlyReducedRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Hourly reduced rate cannot be negative or zero");
        }

//        assign values to fields

        this.kind = kind;
        this.hourlyNormalRate = hourlyNormalRate;
        this.hourlyReducedRate = hourlyReducedRate;
    }

    // Method to calculate rate for a given period
    public BigDecimal calculate(Period period) {
        if (period == null) {
            throw new IllegalArgumentException("Period cannot be null");
        }

        if (period.duration() < 0) {
            throw new IllegalArgumentException("Invalid period");
        }

        if (period.duration() == 0) {
            return BigDecimal.ZERO;
        }

        return hourlyNormalRate.multiply(BigDecimal.valueOf(period.duration()));
    }

    // Getters and Setters
    public CarParkKind getKind() {
        return kind;
    }

    public void setKind(CarParkKind kind) {
        this.kind = kind;
    }

    public BigDecimal getHourlyNormalRate() {
        return hourlyNormalRate;
    }

    public void setHourlyNormalRate(BigDecimal hourlyNormalRate) {
        this.hourlyNormalRate = hourlyNormalRate;
    }

    public BigDecimal getHourlyReducedRate() {
        return hourlyReducedRate;
    }

    public void setHourlyReducedRate(BigDecimal hourlyReducedRate) {
        this.hourlyReducedRate = hourlyReducedRate;
    }
}

package src;

import src.enums.CarParkKind;

import java.math.BigDecimal;

public class Rate {

    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;

    // Constructor
    public Rate(CarParkKind kind, BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate) {
        this.kind = kind;
        this.hourlyNormalRate = hourlyNormalRate;
        this.hourlyReducedRate = hourlyReducedRate;
    }

    // Method to calculate rate for a given period
    public BigDecimal calculate(Period period) {
        if (kind == CarParkKind.VISITOR) {
            return hourlyNormalRate.min(hourlyReducedRate).multiply(BigDecimal.valueOf(period.duration()));
        } else {
            return hourlyNormalRate.multiply(BigDecimal.valueOf(period.duration()));
        }
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

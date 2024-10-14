package src;

import java.util.List;

public class CarParkSystem {
    private String version;
    private String name;
    private List<CarPark> carParks;
    private List<Gate> gates;
    private List<Rate> rates;

    // Constructor
    public CarParkSystem(String version, String name, List<CarPark> carParks, List<Gate> gates, List<Rate> rates) {
        this.version = version;
        this.name = name;
        this.carParks = carParks;
        this.gates = gates;
        this.rates = rates;
    }

    // Getters and Setters
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarPark> getCarParks() {
        return carParks;
    }

    public void setCarParks(List<CarPark> carParks) {
        this.carParks = carParks;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}

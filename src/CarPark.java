package src;

import src.enums.CarParkKind;
import src.enums.CarParkStatus;

public class CarPark {
    private int id;
    private String name;
    private int capacity;
    private int spacesAvailable;
    private CarParkKind kind;
    private CarParkStatus status;

    // Constructor
    public CarPark(int id, String name, int capacity, CarParkKind kind, CarParkStatus status) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.kind = kind;
        this.status = status;
        this.spacesAvailable = capacity;  // initially, all spaces are available
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpacesAvailable() {
        return spacesAvailable;
    }

    public void setSpacesAvailable(int spacesAvailable) {
        this.spacesAvailable = spacesAvailable;
    }

    public CarParkKind getKind() {
        return kind;
    }

    public void setKind(CarParkKind kind) {
        this.kind = kind;
    }

    public CarParkStatus getStatus() {
        return status;
    }

    public void setStatus(CarParkStatus status) {
        this.status = status;
    }
}

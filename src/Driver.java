package src;

import src.enums.CarParkKind;

public class Driver {

    private String name;
    private final int PIN;
    private CarParkKind kind;
    private boolean allowed;
    private Stay stay;

    public Driver(String name, int PIN, CarParkKind kind, boolean allowed) {
        this.name = name;
        this.PIN = PIN;
        this.kind = kind;
        this.allowed = allowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPIN() {
        return PIN;
    }

    public CarParkKind getKind() {
        return kind;
    }

    public void setKind(CarParkKind kind) {
        this.kind = kind;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public Stay getStay() {
        return stay;
    }

    public void setStay(Stay stay) {
        this.stay = stay;
    }
}

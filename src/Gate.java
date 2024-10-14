package src;

import java.util.UUID;

public class Gate {

    private final UUID gateId;
    private String location;

    public Gate(String location) {
        this.gateId = UUID.randomUUID();
        this.location = location;
    }

    public UUID getGateId() {
        return gateId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

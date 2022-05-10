package com.practice.systemdesign.parkinglot;

public interface ParkingSpotAssignmentStrategy {

    ParkingSpot getParkingSpot(Terminal terminal);

    void releaseParkingSpot(ParkingSpot parkingSpot);
}

class ParkingSpotAssignmentNearEntranceStrategy implements ParkingSpotAssignmentStrategy {
    @Override
    public ParkingSpot getParkingSpot(Terminal terminal) {
        return null;
    }

    @Override
    public void releaseParkingSpot(ParkingSpot parkingSpot) {

    }
}

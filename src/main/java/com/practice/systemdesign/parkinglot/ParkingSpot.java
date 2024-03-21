package com.practice.systemdesign.parkinglot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingSpot {

    protected String id;
    protected boolean reserve;

    protected ParkingSpot(String id) {
        this.id = id;
    }
}

class CompactParkingSpot extends ParkingSpot {
    public CompactParkingSpot(String id) {
        super(id);
    }
}

class HandicappedParkingSpot extends ParkingSpot {
    public HandicappedParkingSpot(String id) {
        super(id);
    }
}

class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(String id) {
        super(id);
    }
}

class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(String id) {
        super(id);
    }
}




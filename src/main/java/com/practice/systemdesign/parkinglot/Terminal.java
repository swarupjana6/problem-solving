package com.practice.systemdesign.parkinglot;

import com.practice.systemdesign.parkinglot.exception.UnableToExitException;
import com.practice.systemdesign.parkinglot.models.CompactParkingSpot;

public class Terminal {

    public String getTicketId() {
        return "";
    }
}

class TerminalEntry extends Terminal {
    public Ticket getTicket(ParkingSpot parkingSpot) {
        return Ticket.createTicket(new CompactParkingSpot(""));
    }
}

class TerminalExit extends Terminal {

    public void acceptTicket(Ticket ticket) throws UnableToExitException {

    }
}


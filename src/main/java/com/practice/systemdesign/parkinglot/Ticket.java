package com.practice.systemdesign.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Builder
@Getter
@Setter
public class Ticket {

    private String ticketId;
    private String parkingSpotId;
    private ParkingSpot parkingSpot;
    private LocalTime issueTime;

    public static Ticket createTicket(ParkingSpot parkingSpot) {
        return Ticket.builder()
                .parkingSpot(parkingSpot)
                .issueTime(LocalTime.now())
                .ticketId(String.valueOf(System.currentTimeMillis()))
                .build();
    }
}
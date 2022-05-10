# Parking Lot

1. [ Approach 1 ](#approach-1)
2. [ Approach 2 ](#approach-2)
 

---
<a name="approach-1"></a>
## Approach - 1

1. [ Usecase ](#usecase)
2. [ Problem Details ](#problem-details)
3. [ Scale ](#scale)
4. [ Public APIs ](#apis)
5. [ Concurrency ](#concurrency)
6. [ Distributed ](#distributed)

<a name="usecase"></a>
### 1. Usecase
1. Give user ticket when he/she enters
2. Generate price when they exit

<a name="problem-details"></a>
### 2. Problem Details

1. What details should be in the ticket?
   1. Vehicle no.
   2. Time of entry
   3. Parking spot
   4. Unique id for tracking purposes
2. Allocation of parking to user?
   1. Are there different type of parking
      1. Small
      2. Medium
      3. Large
      4. Handicap
   2. How is the parking spot decided?
      1. Multiple strategy 
3. What logic for generating price?
   1. It can have different policies depending on parameters like type of vehicle etc.

<a name="scale"></a>
### 3. Scale

1. No of parking slots in one parking lot
   1. (# Floor in parking lot) X (# Parking slot per floor)
   2. 10 X 500 = 5000
2. Data size for parking slot in one parking lot
   1. (# parking slot) X (size per parking slot)
   2. 5K X 1K = 5M (Which fits into one machine)
3. Data size for Ticketing per day
   1. (#parking) X (size per ticket)
   2. 10K X 100 = 1MB
4. Data for 10 years: 10 * 365 * 1MB = 3.65 GB (which fits in one machine)

<a name="apis"></a>
### 4. Public APIs

```
VehicleType {
    
}

ParkingService {
    Ticket entry(VehicleType vehicle);
    double exit(long tickerId);
}

Ticket {
    long id;
    DateTime inTime;
    DateTime outTime;
    ParkingSlot slot;
    String vehicleNumber;
}

ParkingSlot {
    long id;
    VehicleType type;
    State state;    // Occupied or not
}

SlotService {
    ParkingSlot allocate(VehicleType type);
    boolean unAllocate(long parkingSlotId);
}

PricingService {
    double calculate(VehicleType type, DateTime inTime, DateTime outTime);
}
```

<a name="concurrency"></a>
### 4. Concurrency (More than one entry/exit)
* Only need to solve for Slot Service 
* Step to consider
  1. Query to find available slots
  2. Pick slot to allocate based on Allocation Strategy
  3. Try to lock the slot. If unavailable, wait. If fails, pick another slot.
  4. Assign the slot to vehicle, make it occupied
  5. Unlock


<a name="distributed"></a>
### 5. Distributed (Large no of parking slots)
* Add Parking Lot id in Tickets, ParkingSlot
* Sharding data
* Tickets and Parking Slot
  * Sharing on the basis of Parking Lot id

---

<a name="approach-2"></a>
## Approach - 2

### Requirements

* Big Parking lot 10k-30k
* 4 entrances and 4 exits
* TICKET ISSUING SERVICE:: Tickets are collected at the entrances
* Parking spot should be nearest to the entrance
* Multilevel parking lot
* Multiple category of parking space
  * Disabled
  * Electric
  * Pregnant women
* LIMIT : Should not allow more vehicles than allocated 
* Charges
  * Hourly
* Display available no of parking space
  * Empty
  * Total
  * Occupied
* PAYMENT SERVICE
  * Cash
  * Card
* Monitoring System


### Bottom Up Approach

Object-oriented is inline with bottom up approach

| ACTORS                                               |
|------------------------------------------------------|
| Parking Lot System                                   |
| Entry and Exit Terminal - Printer, Payment Processes |
| Parking Spot                                         |
| Ticket                                               |
| Monitoring System                                    |
| Database                                             |



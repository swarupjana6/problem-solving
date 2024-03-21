package com.practice.systemdesign.parkinglot;

import java.time.LocalDateTime;

public interface TariffCalculator {
    double calculateTariff(LocalDateTime time);
}

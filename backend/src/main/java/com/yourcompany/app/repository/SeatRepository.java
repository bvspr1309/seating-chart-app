package com.yourcompany.app.repository;

import com.example.SeatingChart.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Add custom query methods if needed
}

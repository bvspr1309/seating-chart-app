package com.yourcompany.app.Controller;

import com.example.SeatingChart.model.Seat;
import com.example.SeatingChart.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatRepository seatRepository;

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        return seatRepository.save(seat);
    }

    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable Long id, @RequestBody Seat seatDetails) {
        Seat seat = seatRepository.findById(id).orElse(null);
        if (seat != null) {
            // Update seat properties
            seat.setSeatNumber(seatDetails.getSeatNumber());
            seat.setAvailability(seatDetails.isAvailability());
            // ...
            return seatRepository.save(seat);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Long id) {
        seatRepository.deleteById(id);
    }
}

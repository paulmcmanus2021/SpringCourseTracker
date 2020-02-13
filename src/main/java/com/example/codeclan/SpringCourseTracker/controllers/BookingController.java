package com.example.codeclan.SpringCourseTracker.controllers;

import com.example.codeclan.SpringCourseTracker.models.Booking;
import com.example.codeclan.SpringCourseTracker.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getOneBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping(value = "/bookings/date")
    public ResponseEntity<List<Booking>> findBookingsByDate(@RequestParam (name = "date") String date){
        List<Booking> foundBookings = bookingRepository.findByDate(date);
        return new ResponseEntity<>(foundBookings, HttpStatus.OK);
    }
}

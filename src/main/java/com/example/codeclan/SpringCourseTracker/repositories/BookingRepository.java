package com.example.codeclan.SpringCourseTracker.repositories;

import com.example.codeclan.SpringCourseTracker.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long > {
    List<Booking> findByDate(String date);
}

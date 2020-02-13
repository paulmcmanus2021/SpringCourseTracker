package com.example.codeclan.SpringCourseTracker.repositories;

import com.example.codeclan.SpringCourseTracker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long id);

    List<Customer> findByBookingsCourseTown(String town);

    List<Customer> findByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseId(int age, String town, long id);
}

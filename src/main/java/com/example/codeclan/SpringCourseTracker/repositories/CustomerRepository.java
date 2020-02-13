package com.example.codeclan.SpringCourseTracker.repositories;

import com.example.codeclan.SpringCourseTracker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

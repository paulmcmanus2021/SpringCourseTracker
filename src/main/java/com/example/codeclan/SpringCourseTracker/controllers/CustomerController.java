package com.example.codeclan.SpringCourseTracker.controllers;

import com.example.codeclan.SpringCourseTracker.models.Customer;
import com.example.codeclan.SpringCourseTracker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getOneCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping(value = "customers/course")
    public ResponseEntity<List<Customer>> getAllCustomersForACourse(@RequestParam (name = "id") Long id){
        List<Customer> foundCustomers = customerRepository.findByBookingsCourseId(id);
        return new ResponseEntity<>(foundCustomers, HttpStatus.OK);
    }
}

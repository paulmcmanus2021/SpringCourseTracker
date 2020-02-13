package com.example.codeclan.SpringCourseTracker.components;

import com.example.codeclan.SpringCourseTracker.models.Booking;
import com.example.codeclan.SpringCourseTracker.models.Course;
import com.example.codeclan.SpringCourseTracker.models.Customer;
import com.example.codeclan.SpringCourseTracker.repositories.BookingRepository;
import com.example.codeclan.SpringCourseTracker.repositories.CourseRepository;
import com.example.codeclan.SpringCourseTracker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        bookingRepository.deleteAll();
        courseRepository.deleteAll();
        customerRepository.deleteAll();

        Course needlework = new Course("Needlework","Glasgow",5);
        courseRepository.save(needlework);

        Course surfing = new Course("Surfing","Glasgow",3);
        courseRepository.save(surfing);

        Customer gregor = new Customer("Gregor","Glasgow",30);
        customerRepository.save(gregor);

        Customer alan = new Customer("Alan","Glasgow",89);
        customerRepository.save(alan);

        Booking booking1 = new Booking("13-02-20",needlework,gregor);
        bookingRepository.save(booking1);
        customerRepository.save(gregor);

        Booking booking2 = new Booking("15-02-20",surfing,alan);
        bookingRepository.save(booking2);
        customerRepository.save(alan);


        Booking booking3 = new Booking("13-02-20",needlework,alan);
        bookingRepository.save(booking3);
        customerRepository.save(alan);


        Booking booking4 = new Booking("15-02-20",surfing,gregor);
        bookingRepository.save(booking4);
        customerRepository.save(gregor);

    }
}

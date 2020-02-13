package com.example.codeclan.SpringCourseTracker;

import com.example.codeclan.SpringCourseTracker.models.Booking;
import com.example.codeclan.SpringCourseTracker.models.Course;
import com.example.codeclan.SpringCourseTracker.models.Customer;
import com.example.codeclan.SpringCourseTracker.repositories.BookingRepository;
import com.example.codeclan.SpringCourseTracker.repositories.CourseRepository;
import com.example.codeclan.SpringCourseTracker.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringCourseTrackerApplicationTests {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSaveAll(){

		Course course = new Course("Needlework","Glasgow",5);
		courseRepository.save(course);

		Customer customer = new Customer("Gregor","Glasgow",30);
		customerRepository.save(customer);

		Booking booking = new Booking("13-02-20",course,customer);
		bookingRepository.save(booking);



	}

}

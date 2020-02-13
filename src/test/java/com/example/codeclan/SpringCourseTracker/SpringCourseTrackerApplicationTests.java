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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

		Course course = new Course("Needlework","Glasgow",4);
		courseRepository.save(course);

		Customer customer = new Customer("Gregor","Glasgow",30);
		customerRepository.save(customer);

		Booking booking = new Booking("13-02-20",course,customer);
		bookingRepository.save(booking);
	}

	@Test
	public void canGetCoursesByRating(){
		List<Course> foundCourses = courseRepository.findByRating(5);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canGetAllCustomersForACourse(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseId(1L);
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canGetAllCoursesForACustomer(){
		Customer stephen = new Customer("Tony","Edinburgh", 10);
		customerRepository.save(stephen);
		Course behaviour = new Course("Behaviour", "Edinburgh",2);
		courseRepository.save(behaviour);
		Booking booking2 = new Booking("28-02-20", behaviour, stephen);
		bookingRepository.save(booking2);

		List<Course> foundCourses = courseRepository.findByBookingsCustomer(stephen);
		assertEquals(1, foundCourses.size());
	}

}

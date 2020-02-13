package com.example.codeclan.SpringCourseTracker.controllers;

import com.example.codeclan.SpringCourseTracker.models.Course;
import com.example.codeclan.SpringCourseTracker.models.Customer;
import com.example.codeclan.SpringCourseTracker.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getOneCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping(value = "/courses/rating")
    public ResponseEntity<List<Course>> getCoursesByRating(@RequestParam(name = "rating") int rating){
        List<Course> foundCourses = courseRepository.findByRating(rating);
        return new ResponseEntity<>(foundCourses, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/customers")
    public ResponseEntity<List<Course>> getCoursesByCustomerId(@RequestParam(name = "id")Long id){
        List<Course> foundCourses = courseRepository.findByBookingsCustomerId(id);
        return new ResponseEntity<>(foundCourses, HttpStatus.OK);
    }


}

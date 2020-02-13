package com.example.codeclan.SpringCourseTracker.repositories;

import com.example.codeclan.SpringCourseTracker.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

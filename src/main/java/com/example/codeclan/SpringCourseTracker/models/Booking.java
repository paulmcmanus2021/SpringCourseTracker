package com.example.codeclan.SpringCourseTracker.models;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Column(name = "date")
    private String date;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    public Booking(String date) {
        this.date = date;
    }

    public Booking() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

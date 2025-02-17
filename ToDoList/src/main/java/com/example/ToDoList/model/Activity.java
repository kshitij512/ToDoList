package com.example.ToDoList.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status; // "Pending", "Completed"

    @Column(name = "day_number")
    private int dayNumber; // The day this activity belongs to

    private boolean completed;  // ✅ Add this field

    // Constructors
    public Activity() {}

    public Activity(String name, String status, int dayNumber, boolean completed) {
        this.name = name;
        this.status = status;
        this.dayNumber = dayNumber;
        this.completed = completed;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getDayNumber() { return dayNumber; }
    public void setDayNumber(int dayNumber) { this.dayNumber = dayNumber; }

    public boolean isCompleted() { return completed; }  // ✅ Getter for completed
    public void setCompleted(boolean completed) { this.completed = completed; }  // ✅ Setter for completed
}

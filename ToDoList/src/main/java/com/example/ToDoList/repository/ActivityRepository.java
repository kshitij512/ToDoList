package com.example.ToDoList.repository;

import com.example.ToDoList.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // Custom method to find activities by day number
    List<Activity> findByDayNumber(int dayNumber);
package com.example.ToDoList.controller;

import com.example.ToDoList.model.Activity;
import com.example.ToDoList.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // Get all activities
    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    // Get activities by day number
    @GetMapping("/day/{dayNumber}")
    public List<Activity> getActivitiesByDay(@PathVariable int dayNumber) {
        return activityService.getActivitiesByDay(dayNumber);
    }

    // Get a single activity by ID
    @GetMapping("/{id}")
    public Optional<Activity> getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    // Add a new activity
    @PostMapping
    public Activity addActivity(@RequestBody Activity activity) {
        return activityService.addActivity(activity);
    }

    // Update an existing activity
    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable Long id, @RequestBody Activity updatedActivity) {
        return activityService.updateActivity(id, updatedActivity);
    }

    // Mark an activity as completed
    @PutMapping("/{id}/complete")
    public Activity markActivityAsComplete(@PathVariable Long id) {
        return activityService.markActivityAsComplete(id);
    }

    // Delete an activity
    @DeleteMapping("/{id}")
    public String deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return "Activity with ID " + id + " has been deleted.";
    }
}

package com.example.ToDoList.service;

import com.example.ToDoList.model.Activity;
import com.example.ToDoList.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    // Get all activities
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    // Get activities by day number
    public List<Activity> getActivitiesByDay(int dayNumber) {
        return activityRepository.findByDayNumber(dayNumber);
    }

    // Get a specific activity by ID
    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    // Add a new activity
    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    // Update an existing activity
    public Activity updateActivity(Long id, Activity updatedActivity) {
        if (activityRepository.existsById(id)) {
            updatedActivity.setId(id);  // Ensure the ID remains the same
            return activityRepository.save(updatedActivity);
        } else {
            throw new RuntimeException("Activity not found with ID: " + id);
        }
    }

    // Mark an activity as completed
    public Activity markActivityAsComplete(Long id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isPresent()) {
            Activity activity = optionalActivity.get();
            activity.setCompleted(true);
            return activityRepository.save(activity);
        } else {
            throw new RuntimeException("Activity not found with ID: " + id);
        }
    }

    // Delete an activity
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}

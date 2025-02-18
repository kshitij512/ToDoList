// src/components/ActivityList.js
import ActivityItem from './ActivityItem.js';

function ActivityList({ activities, markComplete, deleteActivity }) {
  return (
    <div>
      {activities.map((activity) => (
        <ActivityItem
          key={activity.id}
          activity={activity}
          markComplete={markComplete}
          deleteActivity={deleteActivity}
        />
      ))}
    </div>
  );
}

export default ActivityList;
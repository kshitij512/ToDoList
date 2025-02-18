// src/components/ActivityItem.js
function ActivityItem({ activity, markComplete, deleteActivity }) {
  return (
    <div className="flex items-center space-x-2 mb-2">
      <input
        type="checkbox"
        checked={activity.completed}
        onChange={() => markComplete(activity.id)}
        className="h-5 w-5"
      />
      <span className={`flex-1 ${activity.completed ? 'line-through text-gray-400' : ''}`}>
        {activity.name} - Day {activity.day}
      </span>
      <button
        onClick={() => deleteActivity(activity.id)}
        className="text-red-500 hover:text-red-700"
      >
        Delete
      </button>
    </div>
  );
}

export default ActivityItem;

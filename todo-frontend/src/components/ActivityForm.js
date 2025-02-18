// src/components/ActivityForm.js
import { useState } from 'react';

function ActivityForm({ addActivity }) {
  const [activity, setActivity] = useState({ name: '', day: 1 });

  const handleChange = (e) => {
    setActivity({ ...activity, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    addActivity(activity);
    setActivity({ name: '', day: 1 });
  };

  return (
    <form onSubmit={handleSubmit} className="flex space-x-2 mb-4">
      <input
        type="text"
        name="name"
        value={activity.name}
        onChange={handleChange}
        placeholder="Enter activity name"
        className="border border-gray-300 rounded px-4 py-2"
      />
      <input
        type="number"
        name="day"
        value={activity.day}
        onChange={handleChange}
        placeholder="Enter day number"
        className="border border-gray-300 rounded px-4 py-2"
      />
      <button
        type="submit"
        className="bg-blue-500 text-white px-4 py-2 rounded"
      >
        Add Activity
      </button>
    </form>
  );
}

export default ActivityForm;

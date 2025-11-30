import React from 'react';
import { Link } from 'react-router-dom';
import './schedule.css';
import Navbar from '../components/navbar/navbar';

// Komponen placeholder untuk satu item jadwal
// Anda mungkin ingin memindahkannya ke file terpisah (misalnya ScheduleCard.js)
const ScheduleCard = ({ title, description, time, type }) => {
  return (
    <div className="schedule-card">
      <div className="schedule-details">
        <h3>{title}</h3>
        <p>{description}</p>
        <p className="schedule-time">
          **Waktu:** {time}
        </p>
        <p className="schedule-type">
          **Tipe:** {type}
        </p>
      </div>
      <div className="schedule-actions">
        <Link to={`/editSchedule/${id}`} className="btn-edit">Edit</Link>
        <button className="btn-delete">Delete</button>
      </div>
    </div>
  );
};

function Schedule() {
  // Data dummy untuk mereplikasi tampilan
  const dummySchedules = [
    {
      id: 1,
      title: 'Olahraga Pagi',
      description: 'Lari Pagi Keliling Komplek',
      time: '14/10/2022, 06:00 AM',
      type: 'Jadwal Olahraga',
    },
    {
      id: 2,
      title: 'Olahraga Pagi',
      description: 'Lari Pagi Keliling Komplek',
      time: '14/10/2022, 08:00 AM',
      type: 'Jadwal Olahraga',
    },
    {
      id: 3,
      title: 'Olahraga Pagi',
      description: 'Lari Pagi Keliling Komplek',
      time: '14/11/2022, 06:00 AM',
      type: 'Jadwal Olahraga',
    },
    {
      id: 4,
      title: 'Olahraga Pagi',
      description: 'Lari Pagi Keliling Komplek',
      time: '14/11/2022, 08:00 AM',
      type: 'Jadwal Olahraga',
    },
  ];

  return (
    <div className="schedule-wrapper">
      <Navbar />
      
      <div className="schedule-content">
        <div className="schedule-header">
          <h2>All Schedule</h2>
          {/* Menggunakan Link jika ada route ke halaman tambah jadwal, 
              atau button jika menggunakan modal/state */}
          <Link to="/addSchedule" className="btn-add-schedule">
            Add Schedule
          </Link>
        </div>

        <div className="schedule-list">
          {dummySchedules.map((schedule) => (
            <ScheduleCard
              key={schedule.id}
              title={schedule.title}
              description={schedule.description}
              time={schedule.time}
              type={schedule.type}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default Schedule;
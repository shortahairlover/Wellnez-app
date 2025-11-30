// src/App.js

import React from 'react';
import './App.css';
// Import Routes dan Route dari react-router-dom
import { Routes, Route } from 'react-router-dom'; 

// Import komponen-komponen yang akan dirouting
import LandingPage from './components/landingpage/landingpage';
import Navbar from './components/navbar/navbar';
import Login from './login/login'; 
import Register from './register/register';
import Mainpage from './mainpage/mainpage';
import Schedule from './schedule/schedule';
import AddSchedule from './schedule/addSchedule/addSchedule';
import EditSchedule from './schedule/editSchedule/editSchedule';
// Asumsi path login/login.js benar

function App() {
  return (
    <div className="App">
      {/* Gunakan Routes sebagai container untuk semua Route */}
      <Routes>
        
        {/* Rute 1: Halaman Beranda/Landing Page */}
        <Route path="/" element={<LandingPage />} />
        
        {/* Rute 2: Halaman Login */}
        <Route path="/login" element={<Login />} />

        {/* Rute 2: Halaman Login */}
        <Route path="/register" element={<Register />} />

        <Route path="/navbar" element={<Navbar />} />

        <Route path="/mainpage" element={<Mainpage />} />

        <Route path="/schedule" element={<Schedule />} />

        <Route path="/addSchedule" element={<AddSchedule />} />

        <Route path="/editSchedule" element={<EditSchedule />} />
        
        {/* Anda bisa menambahkan rute lain di sini, misalnya /register */}
        {/* <Route path="/register" element={<Register />} /> */}
        
      </Routes>
    </div>
  );
}

export default App;
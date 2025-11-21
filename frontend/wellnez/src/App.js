// src/App.js

import React from 'react';
import './App.css';
// Import Routes dan Route dari react-router-dom
import { Routes, Route } from 'react-router-dom'; 

// Import komponen-komponen yang akan dirouting
import LandingPage from './components/landingpage/landingpage';
import Login from './login/login'; 
import Register from './register/register';
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
        
        {/* Anda bisa menambahkan rute lain di sini, misalnya /register */}
        {/* <Route path="/register" element={<Register />} /> */}
        
      </Routes>
    </div>
  );
}

export default App;
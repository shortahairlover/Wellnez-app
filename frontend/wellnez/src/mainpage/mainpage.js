import React from 'react';
import { Link } from 'react-router-dom';
import './mainpage.css';
import doctorImage from '../components/gambar/goatdokter.png';

// Import komponen Navbar yang sudah Anda buat
import Navbar from '../components/navbar/navbar'; 

// Import ikon placeholder (Ganti dengan ikon actual jika Anda menggunakan library seperti react-icons)
const IconArticle = () => <div className="mainpage-icon article-icon">📄</div>;
const IconSchedule = () => <div className="mainpage-icon schedule-icon">📅</div>;
const IconManage = () => <div className="mainpage-icon manage-icon">🥗</div>;


function Mainpage() {
  return (
    // Tambahkan Navbar di bagian atas
    <div className="mainpage-wrapper">
        <Navbar /> 
        
        {/* Konten Mainpage yang tampil di bawah Navbar */}
        <div className="mainpage-container">
            <div className="mainpage-content">
                
                {/* === Kiri: Header dan Tombol === */}
                <div className="mainpage-left">
                    <h1 className="mainpage-title">Wellnez</h1>
                    <h2 className="mainpage-tagline">Together We Build a Better Life</h2>
                    
                    <div className="mainpage-features">
                        
                        {/* 1. View Article */}
                        <Link to="/article" className="feature-card">
                            <IconArticle />
                            <span className="feature-text">View Article</span>
                        </Link>
                        
                        {/* 2. Make Schedule */}
                        <Link to="/schedule" className="feature-card">
                            <IconSchedule />
                            <span className="feature-text">Make Schedule</span>
                        </Link>
                        
                        {/* 3. Manage Food */}
                        <Link to="/managefood" className="feature-card">
                            <IconManage />
                            <span className="feature-text">Manage Food</span>
                        </Link>
                    </div>
                </div>
                
                {/* === Kanan: Gambar Dokter === */}
                <div className="mainpage-right">
                    <img src={doctorImage} alt="Goat Dokter" className="doctor-image" />
                </div>
            </div>
        </div>
    </div>
  );
}

export default Mainpage;
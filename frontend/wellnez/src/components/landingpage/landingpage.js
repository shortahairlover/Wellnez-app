import React from 'react';
import './landingpage.css';
// Mengasumsikan logo Anda berada di folder 'src', atau sesuaikan path-nya
import WellnezLogo from '../gambar/logowellnez.png'; 
import { Link } from 'react-router-dom';

function LandingPage() {
  return (
    <div className="landing-page">
      <header className="page-header">
        <p className="welcome-text">WELCOME TO WELLNEZ</p>
        
        <img src={WellnezLogo} className="logo-image" alt="Wellnez Logo" />
        
        <p className="tagline">ACCOMPANYING YOU IN A HEALTHY LIFE</p>
        
        <Link to="/login" className="get-started-button">
            Get Started
        </Link>
      </header>
    </div>
  );
}

export default LandingPage;
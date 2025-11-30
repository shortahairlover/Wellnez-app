import React from 'react'; // Jika menggunakan React
import './navbar.css';
import logo from '../gambar/logowellnez.png';
import { Link } from 'react-router-dom';

function Navbar() {
  const handleLogout = () => {
    localStorage.clear();
    // Logika untuk logout
    console.log('User logged out');
  };
  
  // Fungsi untuk mensimulasikan navigasi
  

  return (
    <nav className="navbar">
      <div className="navbar-logo-container">
        <Link to="/mainpage">
        <img src={logo} alt="Wellnez Logo" className="navbar-logo" />
        </Link>
      </div>
      
      <div className="navbar-links">
        <Link to="/managefood" className="nav-link">
          Manage Food
        </Link>
        
        <Link to="/schedule" className="nav-link">
          Schedule
        </Link>
        
        
        <Link to="/article" className="nav-link">
          Article
        </Link>
        
        
        <button onClick={handleLogout} className="logout-button">
          Logout
        </button>
      </div>
    </nav>
  );
}

export default Navbar;
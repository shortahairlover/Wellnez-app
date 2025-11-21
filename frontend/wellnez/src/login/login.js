import React from 'react';
import './login.css'; // Import file CSS
import logowellnez from '../components/gambar/logowellnez.png'; // Sesuaikan path jika berbeda
import { Link } from 'react-router-dom';

function Login() {
  return (
    <div className="login-page">
      <div className="app-header">
        <img src={logowellnez} className="app-logo-image" alt="logo Wellnez" />
        
      </div>

      {/* Container Form Login Utama */}
      <div className="login-container">
        <h2 className="login-title">Login</h2>
        
        <form className="login-form">
          {/* Input Email */}
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input 
              type="email" 
              id="email" 
              placeholder="Enter Email" 
              className="form-input"
            />
          </div>

          {/* Input Password */}
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input 
              type="password" 
              id="password" 
              placeholder="Enter Password" 
              className="form-input"
            />
          </div>

          {/* Tombol Login */}
          <button type="submit" className="login-button">
            Login
          </button>
        </form>

        {/* Link Register */}
        <p className="register-link-text">
          Don't Have an Account? <Link to="/register" className="register-link">Register Now</Link>
        </p>
      </div>
    </div>
  );
}

export default Login;
import React from 'react';
import './register.css'; // Import file CSS
import logowellnez from '../components/gambar/logowellnez.png'; // Sesuaikan path jika berbeda
import { Link } from 'react-router-dom';

function Register() {
  return (
    <div className="register-page">
      <div className="app-header">
        <img src={logowellnez} className="app-logo-image" alt="logo Wellnez" />
        
      </div>

      {/* Container Form Login Utama */}
      <div className="register-container">
        <h2 className="register-title">Register</h2>
        
        <form className="register-form">
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

          <div className="form-group">
            <label htmlFor="email">Username</label>
            <input 
              type="username" 
              id="username" 
              placeholder="Enter Username" 
              className="form-input"
            />
          </div>

          <div className="form-group">
            <label htmlFor="email">Name</label>
            <input 
              type="name" 
              id="name" 
              placeholder="Enter Real Name" 
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

          <div className="form-group">
            <label htmlFor="password">Confirm Password</label>
            <input 
              type="password" 
              id="password" 
              placeholder="Enter Password" 
              className="form-input"
            />
          </div>

          
          <button type="submit" className="login-button">
            Register
          </button>
        </form>

        
        <p className="login-link-text">
          Already Have an Account? <Link to="/login" className="login-link">Login</Link>
        </p>
      </div>
    </div>
  );
}

export default Register;
import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import Swal from 'sweetalert2';

function Login({onForgotPassword,onRegister}) {
  
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

   function successAlert(title){
          Swal.fire({
              toast: true,
              position: 'bottom-end',
              showConfirmButton: false,
              icon: 'success',
              timer: 3000,
              title: title
          });
      };
      
     
      function failure(title) {
          Swal.fire({
              toast: true,
              position: 'bottom-end',
              showConfirmButton: false,
              icon: 'error',
              timer: 3000,
              title: title
          });
      };

  const validateEmail = (value) => {
    if (!value) {
      setEmailError("Email is required");
    } else if (!/\S+@\S+\.\S+/.test(value)) {
      setEmailError("Invalid email format");
    } else {
      setEmailError("");
    }
  };

  const validatePassword = (value) => {
    if (!value) {
      setPasswordError("Password is required");
    } else if (value.length < 6) {
      setPasswordError("Password must be at least 6 characters");
    } else {
      setPasswordError("");
    }
  };

  function check(){
    if (!email || !password) {
      setError("All fields are required!");
      return;
    }

    if (emailError || passwordError) {
      return; // Stop submission if there are validation errors
    }
    setError("");
    successAlert('Logged in Successfully!');
    navigate("/home-dashboard")
  }

  
  function onForgotPassword(){
    navigate("/forgot-password")
  }

  function onRegister(){
    navigate("/sign-up")
  }
  const handleLogin = (event) => {
    event.preventDefault();

    validateEmail(email);
    validatePassword(password);
    
  };

  const styles={
    card: { width: "400px",  background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"}, 
};

  return(
    <div className="bg-primary-subtle" style={styles.body}>
      
      <div className="vh-100 d-flex justify-content-center align-items-center">
      <div className="card p-4 text-white --bs-secondary-bg-rgb" style={styles.card} >
        <h2 className="text-center">LOGIN</h2>
        <form onSubmit={handleLogin} noValidate>
          {/* username */}
          <div className="mb-3">
            <label htmlFor="Email" className="form-label">Username</label>
            <input type="email" className={`form-control ${emailError ? "is-invalid" : ""}`}  value={email} onChange={(e) => { setEmail(e.target.value); validateEmail(e.target.value);}}/>
            {emailError && <div className="invalid-feedback">{emailError}</div>}
          </div>
          {/* password */}
          <div>
            <label htmlFor="inputPassword5" className="form-label">Password</label>
            <input type="password" id="password" className={`form-control ${passwordError ? "is-invalid" : ""}`} value={password} onChange={(e) => { setPassword(e.target.value); validatePassword(e.target.value);}}/>
            {passwordError && <div className="invalid-feedback">{passwordError}</div>}
          </div>
          <p className="text-end"> <a class="link-opacity-100-hover" href="#" onClick={onForgotPassword}>Forgot password?</a></p>
          {/* submit */}
          {error && <p className="text-danger fs-6 fw-bolder">{error}</p>}
          <div>
            <button className="btn btn-primary mt-5 w-50 d-grid mx-auto" type="submit" onClick={check}>
              Login
            </button>
            <p className="text-center mt-2">Don't have an account? <a class="link-opacity-100-hover" href="#" onClick={onRegister}>Sign up</a> here</p>
          </div>
        </form>
      </div>
    </div>
    </div>
 
  );
  }

export default Login;


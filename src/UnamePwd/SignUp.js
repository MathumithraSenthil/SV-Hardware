import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import Swal from 'sweetalert2';

function SignUp({onBack}){
    const [validated, setValidated] = useState(false);
    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const [Name, setName] = useState("");
    const [role, setrole] = useState("");
    const [phone, setphone] = useState("");
    const [email, setEmail] = useState("");
    const [newPassword, setNewPassword] = useState("");
    const [confirmNewPassword, setConfirmNewPassword] = useState("");

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
    
    function handleSignUp(event) {
        event.preventDefault();
        validateEmail(email);
        validatePassword(newPassword);
        if (newPassword !== confirmNewPassword) {
          failure('Password do not match!');
          return;
        }
        if (!Name ||!role || !email || !phone || !newPassword || !confirmNewPassword) {
          setError("All fields are required!");
          return;
        }
        setError(""); // Clear error
        successAlert("Form submitted successfully!");
        onBack();
        }

        function onBack(){
          navigate("/login")
        }
    const styles={
        card: { width: "400px",  background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"},
        select: {height: "42px", width: "350px"},
    };
    return(
        <div className="bg-primary-subtle">
            {/*Nav bar */}
        
            <div className="container vh-100 d-flex justify-content-center align-items-center" style={styles.page}>
                <div className="card p-4 mt-4" style={ styles.card}>
                    <h2 className="text-center mb-2 text-white">Sign Up</h2>
                    <form onSubmit={handleSignUp} noValidate className={validated ? "was-validated" : ""}>

                    <div className="mb-2">
                        <label className="form-label text-white">Name:</label>
                        <input 
                        type="name" 
                        className="form-control fst-italic" 
                        value={Name} 
                        onChange={(e) => setName(e.target.value)} 
                        required 
                        />
                    
                    </div>

                    <div >
                    <label className="form-label text-white">Role</label>
                    <br/>
                    <select class="form-select-sm mb-1" style={styles.select} aria-label="Large select example" 
                    value={role} 
                    onChange={(e) => setrole(e.target.value)} >
                        <option value="" disabled>Select Role</option>
                        <option value="sales">Admin</option>
                        <option value="service">User</option>
                    </select>
                    </div>

                    <div >
                        <label className="form-label text-white"> Phone</label>
                        <input 
                        type="phone" 
                        className="form-control fst-italic" 
                        value={phone} 
                        onChange={(e) => setphone(e.target.value)} 
                        required
                        />
                    </div>

                    <div >
                        <label className="form-label text-white">Email</label>
                        <input 
                            type="Email" 
                            className={`form-control ${emailError ? "is-invalid" : ""}`} 
                            id="email" 
                            value={email}
                            onChange={(e) => {
                            setEmail(e.target.value);
                            validateEmail(e.target.value);
                            }}
                            />
                        {emailError && <div className="invalid-feedback">{emailError}</div>}
                        </div>
            
                    <div >
                        <label className="form-label text-white">Password</label>
                        <input 
                            type="Password" 
                            className={`form-control ${passwordError ? "is-invalid" : ""}`} 
                            id="password" 
                            value={newPassword}
                            onChange={(e) => {
                            setNewPassword(e.target.value);
                            validatePassword(e.target.value);
                            }}
                            />
                            {passwordError && <div className="invalid-feedback">{passwordError}</div>}
                    </div>
            
                    <div className="mb-3">
                        <label className="form-label text-white">Confirm Password</label>
                        <input 
                            type="Confirm Password" 
                            className="form-control fst-italic" 
                            value={confirmNewPassword} 
                            onChange={(e) => setConfirmNewPassword(e.target.value)} 
                            required
                        />
                    </div>

                    {error && <p className="text-danger fs-5 fw-bolder ">{error}</p>}

                     {/* SignUp Button */}

                    <button type="submit" className="btn btn-primary w-50 d-grid mx-auto" >Sign Up</button>
                    
                    {/* Login Button */}

                    <button className="btn btn-link d-grid w-100 mx-auto text-white"  onClick={onBack}>login</button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default SignUp
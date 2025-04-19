import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import  ApiService from '../ApiService';
import { successAlert, failure } from '../Dashboard/Dashboard';
import Swal from 'sweetalert2';



function CreateCustomer() {
    const navigate = useNavigate();
    const [validated, setValidated] = useState(false);
    const [primaryEmailError, setPrimaryEmailError] = useState("");
    const [secondaryEmailError, setSecondaryEmailError] = useState("");
    const [error, setError] = useState("");

    const [surname, setSurname] = useState("");
    const [firstname, setFirstname] = useState("");
    const [middlename, setMiddlename] = useState("");
    const [lastname, setLastname] = useState("");
    const [primarycontact, setPrimaryContact] = useState("");
    const [secondarycontact, setSecondaryContact] = useState("");
    const [primaryEmail, setPrimaryEmail] = useState("");
    const [secondaryEmail, setSecondaryEmail] = useState("");
    
    // Success Alert Function
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

// Error Alert Function
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

    
    const validatePrimaryEmail = (value) => {
        if (!value) {
            setPrimaryEmailError("Primary Email is required");
        } else if (!/\S+@\S+\.\S+/.test(value)) {
            setPrimaryEmailError("Invalid email format");
        } else {
            setPrimaryEmailError("");
        }
    };

    const validateSecondaryEmail = (value) => {
        if (!value) {
            setSecondaryEmailError("Secondary Email is required");
        } else if (!/\S+@\S+\.\S+/.test(value)) {
            setSecondaryEmailError("Invalid email format");
        } else {
            setSecondaryEmailError("");
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        
        validatePrimaryEmail(primaryEmail);
        validateSecondaryEmail(secondaryEmail);

        if (!surname || !firstname || !lastname || !primarycontact || !secondarycontact || !primaryEmail || !secondaryEmail) {
            setError("All fields are required!");
            return;
        }
        if (primaryEmailError || secondaryEmailError) {
            return; // Stop submission if there are validation errors
        }

        setError("");

        // Create a customer object
        const customerData = {
            surname: surname,
            firstName: firstname,
            middleName: middlename,
            lastName: lastname,
            primaryContact: primarycontact,
            secondaryContact: secondarycontact,
            primaryEmail: primaryEmail,
            secondaryEmail: secondaryEmail
        };
        const response = await ApiService.saveCustomer(customerData);
         if(response!=null){
            if(response.status===200){
                //swal service customer created Successfullt
                successAlert("Customer Created Successfully");
                navigate("/customer-list");
//                window.location.reload();
            }else{
                failure("Customer Creation Failed");
            }
         }
       
    };

    const GoToList = () => {
      
    }

    const handleReset = () => {
        setSurname("");
        setFirstname("");
        setMiddlename("");
        setLastname("");
        setPrimaryContact("");
        setSecondaryContact("");
        setPrimaryEmail("");
        setSecondaryEmail("");
        setError("");
    };
  

    return (
        <div className="bg-primary-subtle">
            <div className="container vh-100 d-flex justify-content-center align-items-center" >
                <div className="card p-4" style={{ width: "600px", background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)" }}>
                    <h2 className="text-center mb-4 text-white">Create Customer</h2>
                    <form onSubmit={handleSubmit} noValidate className={validated ? "was-validated" : ""}>
                  
                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Sur name</label>
                                <input type="text" className="form-control fst-italic" value={surname} onChange={(e) => setSurname(e.target.value)} required />
                            </div>
                            <div className="col">
                                <label className="form-label text-white">First name</label>
                                <input type="text" className="form-control fst-italic" value={firstname} onChange={(e) => setFirstname(e.target.value)} required />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Middle name</label>
                                <input type="text" className="form-control fst-italic" value={middlename} onChange={(e) => setMiddlename(e.target.value)} required />
                            </div>
                            <div className="col">
                                <label className="form-label text-white">Last name</label>
                                <input type="text" className="form-control fst-italic" value={lastname} onChange={(e) => setLastname(e.target.value)} required />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Primary Contact</label>
                                <input type="tel" className="form-control fst-italic" value={primarycontact} onChange={(e) => setPrimaryContact(e.target.value)} required />
                            </div>
                            <div className="col">
                                <label className="form-label text-white">Secondary Contact</label>
                                <input type="tel" className="form-control fst-italic" value={secondarycontact} onChange={(e) => setSecondaryContact(e.target.value)} required />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Primary Email</label>
                                <input type="email" className={`form-control ${primaryEmailError ? "is-invalid" : ""}`} value={primaryEmail} onChange={(e) => setPrimaryEmail(e.target.value)} required />
                                {primaryEmailError && <div className="invalid-feedback">{primaryEmailError}</div>}
                            </div>
                            <div className="col">
                                <label className="form-label text-white">Secondary Email</label>
                                <input type="email" className={`form-control ${secondaryEmailError ? "is-invalid" : ""}`} value={secondaryEmail} onChange={(e) => setSecondaryEmail(e.target.value)} required />
                                {secondaryEmailError && <div className="invalid-feedback">{secondaryEmailError}</div>}
                            </div>
                        </div>

                        {error && <p className="text-danger fs-6 fw-bolder">{error}</p>}

                        <div className="text-center mt-3">
                            <button type="submit" className="btn btn-primary w-50 d-grid mx-auto">Create</button>
                            <button type="button" className="btn btn-secondary w-50 d-grid mx-auto mt-3" onClick={handleReset}>Cancel</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    );
}

export default CreateCustomer;

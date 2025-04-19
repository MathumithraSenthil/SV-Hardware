import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Swal from 'sweetalert2';

// Success Alert Function
export const successAlert = (title) => {
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
export const failure = (title) => {
    Swal.fire({
        toast: true,
        position: 'bottom-end',
        showConfirmButton: false,
        icon: 'error',
        timer: 3000,
        title: title
    });
};

const Dashboard = () => {
    const styles = {
        card: { 
            width: "600px",  
            background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119))", 
            boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"
        },
    };

    return (
        <div className="bg-primary-subtle">
            <div className="container vh-100 d-flex justify-content-center align-items-center">
                <div className="card p-4" style={styles.card}>
                    <button onClick={() => successAlert('Success message!')}>Show Success Alert</button>
                    <button onClick={() => failure('Error message!')}>Error Alert</button>
                </div>
            </div>
        </div>
    );
}

// Export Dashboard Component
export default Dashboard;

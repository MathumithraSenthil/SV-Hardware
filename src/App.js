import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate, useNavigate } from "react-router-dom";
import Login from "./UnamePwd/Login";
import IsCustomerExists from "./Order/DeliveredOrderList";
import CustomerList from "./customer/CustomerList";
import CreateCustomer from "./customer/Create_customer";
import CreateOrder from "./Order/CreateOrder";
import OrderList from "./Order/OrderList";
import DeliveredOrderList from "./Order/DeliveredOrderList";
import Sidebar from "./sidebar_navbar/sidebar";
import Navbar from "./sidebar_navbar/navbar";
import Dashboard from "./Dashboard/Dashboard";
import HomeDashboard from "./Dashboard/HomeDahboard";
import DoughnutDashboard from "./Dashboard/DoughnutDashboard";
import ChangePassword from "./UnamePwd/ChangePassword";
import SignUp from "./UnamePwd/SignUp";

function App(){

  
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const navigate = useNavigate();

    // Function to navigate to Create Customer
    const goToCreateCustomer = () => {
        navigate("/create-customer");
    };
  return (
      
      <div>
        <Navbar /> 
      <div style={{ display: "flex" }}>
        <Sidebar /> 
        {isLoggedIn && <Sidebar />}
        {/* Main Content Area */}
        <div style={{
          
          marginLeft: "0px",
          width: "100%",
          overflow: "auto",
          marginTop: "0px",
          minHeight: "auto",   
          backgroundColor: "#f8f9fa", 
        }}>
          <Routes path="/">
            <Route index path="/login" element={<Login/> } />
            <Route path="/forgot-password" element={< ChangePassword/>}/>
            <Route path="/sign-up" element={< SignUp/>}/>
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/home-dashboard" element={<HomeDashboard />} />
            <Route path="/doughnut-dashboard" element={<DoughnutDashboard />} />
            <Route path="/customer-exists" element={< IsCustomerExists/>}/>
            <Route path="/create-customer" element={<CreateCustomer/>} />
            <Route path="/customer-list" element={<CustomerList/>} />
            <Route path="/delivered-order-list" element={<DeliveredOrderList/>} />
            <Route path="/order-list" element={<OrderList/>} />
            <Route path="/create-order" element={<CreateOrder />} />
             {/* Route for the Create/Edit Order page */}
        <Route path="/create-order/:orderId" element={<CreateOrder />} />
            {/* Redirect to login if not logged in */}
            {!isLoggedIn && <Route path="*" element={<Navigate to="/login" />} />}
          </Routes>
        </div>
      </div>
      </div>
  );
}

export default App
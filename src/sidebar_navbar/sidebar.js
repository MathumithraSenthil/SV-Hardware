import React from "react";
import { Link, useLocation } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

const Sidebar = () => {

  const location = useLocation();

  if (["/login", "/forgot-password", "/sign-up"].includes(location.pathname)) {
    return null;
}
  return (
    <div
      style={{
        width: "210px",
        height: "100vh",
        marginTop: "60px",
        backgroundColor: "rgb(13, 21, 144)",
        color: "white",
        paddingTop: "20px",
        position: "fixed",
      }}
    >
     
      <ul className="nav flex-column">
      {/* <li className="nav-item">
          <Link className="nav-link text-white" to="/dashboard">
            Dashboard
          </Link>
        </li> */}
        <li className="nav-item">
          <Link className="nav-link text-white" to="/home-dashboard">
          Dashboard &nbsp; <i class="fa fa-tachometer" aria-hidden="true"></i>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/create-customer">
            Create Customer &nbsp; <i class="fa fa-plus-circle" aria-hidden="true"></i>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/customer-list">
          CustomerList &nbsp; <i class="fa fa-list" aria-hidden="true"></i>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/create-order">
            Create Order &nbsp; <i class="fa fa-plus-circle" aria-hidden="true"></i>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/order-list">
          Order List &nbsp; <i class="fa fa-list" aria-hidden="true"></i>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/delivered-order-list">
          Delivered Order List &nbsp; <i class="fa fa-list" aria-hidden="true"></i>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/login">
            Logout &nbsp;<i class="fa fa-sign-out" aria-hidden="true"></i>
          </Link>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;

import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const Navbar = () => {
    return (
      <nav className="navbar "
        style={{
          width: "100%",
          background: "rgb(13, 21, 144)",
          position: "fixed",
          top: "0",
          left: "0",
          zIndex: "1000",
          padding:"10px 10px 10px 40px",
          height: "60px",  // Fixed height
        }}>
        <div className="container-fluid ">
          <h2 className="text-white ">DCRK</h2>
        </div>
      </nav>
    );
  };

  export default Navbar
  
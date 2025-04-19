import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import DoughnutDashboard from '../Dashboard/DoughnutDashboard'
import BarChartDashboard from '../Dashboard/BarChartDashboard';
import PieChartDashboard from '../Dashboard/PieChartDashboard';
import LineChartDashboard from '../Dashboard/LineChartDashboard';
function HomeDashboard(){
    
    return(
      
        <div className="container" style={{paddingTop:"100px", paddingLeft:"200px"}}>
          <div className="row justify-content-center">
            {/* Doughnut chart */}
            <div className="col-md-5">
              <div className="card">
                <div className="card-header">
                Doughtnut Chart
                </div>
                <div className="card-body">
                <DoughnutDashboard />
                </div>
              </div>
            </div>
            
            {/*Bar chart */}
            <div className="col-md-5">
              <div className="card">
                <div className="card-header">
                Pie Chart
                </div>
                <div className="card-body">
                <PieChartDashboard />
                </div>
              </div>
            </div>
            
        </div>
        <div className="row justify-content-center mt-4">
        {/*Bar chart */}
        {/* <div className="col-md-5">
              <div className="card">
                <div className="card-header">
                Bar Chart
                </div>
                <div className="card-body">
                <BarChartDashboard />
                </div>
              </div>
            </div> */}

        {/*Line chart */}
        {/* <div className="col-md-5">
              <div className="card">
                <div className="card-header">
                Line Chart
                </div>
                <div className="card-body">
                <LineChartDashboard />
                </div>
              </div>
            </div> */}
      </div>
</div>
    );
}
export default HomeDashboard
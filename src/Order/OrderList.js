import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useEffect } from "react";
import axios from "axios";
import { Table, Alert } from "react-bootstrap";

import { Link, useLocation } from "react-router-dom";
function OrderList() {
    
    const [orders, setOrders] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    // Fetch customers from backend
    useEffect(() => {
        const fetchOrders = async () => {
            try {
                const response = await axios.get("http://localhost:9887/order/getAllOrdersList");
                setOrders(response.data);
            } catch (error) {
                //console.error("Error fetching orders:", error);
                setError("Failed to load order data.");
            }
        };
        fetchOrders();
    }, []);

    // const handleEditOrder = async () => {

    //     try {
    //         const response = await axios.post('http://localhost:9887/order/saveOrder');
    //         alert("Order updated successfully!");
    //         //console.log("Response:", response.data);

    //     } catch (error) {
    //        // console.error("Error updating order:", error);
    //         setError("Failed to update order. Please try again.");
    //     }
    // }

    const handleDeliveredOrder = async (orderId) => {
        debugger;
        try {
            const resp = await axios.post('http://localhost:9887/order/deliverOrder?orderId=' + String(orderId));          
           // console.log("Response:", resp.data);
            window.location.reload();

        } catch (error) {
            //console.error("Error delivered order:", error);
            setError("Failed to delivered order. Please try again.");
        }
    }

    return (
        <div className="container mt-4" style={{ marginRight: "0px" }}>
            <div className="container bg-primary-subtle p-3 rounded " style={{ marginTop: "80px" }} >
                <h2 className="text-center bg-primary-subtle">Order List</h2>
                {!error && orders.length > 0 ? (
                    <Table striped bordered hover className="mt-3">
                        <thead>
                            <tr>
                                <th>Type of operation</th>
                                <th>Type of problem</th>
                                <th>Total Amount</th>
                                <th>Balance Amount</th>
                                <th>Advance Amount</th>
                                <th>Payment mode</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {orders.map((orderDto) => (
                                <tr key={orderDto.id}>
                                    <td>{orderDto.typeOfOperation}</td>
                                    <td>{orderDto.typeOfProblem}</td>
                                    <td>{orderDto.totalAmount}</td>
                                    <td>{orderDto.balanceAmount}</td>
                                    <td>{orderDto.advanceAmount}</td>
                                    <td>{orderDto.paymentMode}</td>
                                    <td>

                                    <Link to={`/create-order/${orderDto.orderId}`} className="btn btn-sm" title="Edit"> <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></Link>&nbsp;
                                        <button type="delivered" className="btn btn-sm " title="Delivered" style={{ cursor: "pointer" }} onClick={() => handleDeliveredOrder(orderDto.orderId)}> <a href="#"><i class="fa fa-archive" aria-hidden="true"></i></a></button>&nbsp;
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                ) : (
                    <div class=" col-md-12 row">

                        <div className="col-md-5">

                        </div>
                        <div className="col-md-5" style={{ marginLeft: 44 }}>
                            No orders found.
                        </div>
                        <div class="col-md-2">

                        </div>
                    </div>

                )}

            </div>
        </div>
    );
}
export default OrderList
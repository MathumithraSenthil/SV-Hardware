import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { Table } from "react-bootstrap";

function DeliveredOrderList(){
    const [orders, setOrders] = useState([]);
    const [error, setError] = useState("");

    // Fetch customers from backend
    useEffect(() => {
        const fetchOrders = async () => {
            try {
                const response = await axios.get("http://localhost:9887/order/displayDeliveredOrders");
                setOrders(response.data);
            } catch (error) {
               // console.error("Error fetching orders:", error);
                setError("Failed to load order data.");
            }
        };
        fetchOrders();
    }, []);

    return(
        <div className="container mt-4" style={{ marginRight: "0px" }}>
        <div className="container bg-primary-subtle p-3 rounded"  style={{ marginTop: "80px" }}>
            <h2 className="text-center bg-primary-subtle">Delivered Order List</h2>
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
                                <button className="btn btn-sm" title="Excel" ><a href="#"><i class="fa fa-file-excel-o" aria-hidden="true"></i></a></button>&nbsp;
                                <button className="btn  btn-sm" title="PDF"><a href="#"><i class="fa fa-file-pdf-o" aria-hidden="true"></i></a></button>
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

export default DeliveredOrderList
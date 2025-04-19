import React, { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { Table, Alert, Modal, Button, Form } from "react-bootstrap";

function CustomerList() {
    const [customers, setCustomers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [showModal, setShowModal] = useState(false);
    const [selectedCustomer, setSelectedCustomer] = useState(null);

    // Fetch customers from backend
    useEffect(() => {
        const fetchCustomers = async () => {
            try {
                const response = await axios.get("http://localhost:9887/customer/getAllCustomer");
                //console.log("Customer Data:", response.data);
                setCustomers(response.data);

            } catch (error) {
               // console.error("Error fetching customers:", error);
                setError("Failed to load customer data.");
            } finally {
                setLoading(false);
            }
        };
        fetchCustomers();
    }, []);

    // Open modal and set selected customer
    const handleEditCustomer = (customer) => {
        setSelectedCustomer(customer);
        setShowModal(true);
    };

    // Handle input change in modal form
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        
        setSelectedCustomer({ ...selectedCustomer, [name]: value });
    };

    // Update customer data
    const handleUpdateCustomer = async (e) => {
        e.preventDefault();
        try {
            const response =  await axios.post(`http://localhost:9887/customer/saveCustomer`, selectedCustomer);
           // console.log("Response:", response.data);
            setShowModal(false);
         window.location.reload();
        } catch (error) {
           // console.error("Error updating customer:", error);
            setError("Failed to update customer.");
        }
    };

    const handleDeleteCustomer = async (customerId) => {
        
        if (!window.confirm("Are you sure you want to delete this customer?"))
             return;
        try {
            const resp=await axios.post(`http://localhost:9887/customer/deleteCustomer?customerId=` + String(customerId));
           // console.log("Response:", resp.data);      
             window.location.reload();
        } catch (error) {
           // console.error("Error deleting customer:", error);
            setError("Failed to delete customer.");
        }
    };
    
const activateCustomer=async(customerId) =>{
    try {
        const resp=await axios.post(`http://localhost:9887/customer/activateOrDeactivateCustomer?customerId=` + String(customerId));
       // console.log("Response:", resp.data);      
         window.location.reload();
    } catch (error) {
       // console.error("Error deleting customer:", error);
        setError("Failed to delete customer.");
    }
}

    return (
        <div className="container mt-4 bg-primary-subtle" style={{marginRight: "0px"}}>
            <div className="container bg-primary-subtle p-3 rounded"  style={{ marginTop: "80px" }}>
                <h2 className="text-center">Customer List</h2>
                {error && <Alert variant="danger">{error}</Alert>}
                {loading ? (
                    <p className="text-center text-muted">Loading customers...</p>
                ) : customers.length > 0 ? (
                    <Table striped bordered hover className="mt-3">
                        <thead>
                            <tr>
                              
                                <th>Sur Name</th>
                                <th>First Name</th>
                                <th>Middle Name</th>   
                                <th>Last Name</th>
                                <th>Primary Contact</th>
                                <th>Secondary Contact</th>
                                <th>Primary Email</th>
                                <th>Secondary Email</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {customers.map((customer, index) => (
                                <tr key={customer.id || index}>
                                    <td>{customer.surname}</td>
                                    <td>{customer.firstName}</td>
                                    <td>{customer.middleName}</td>
                                    <td>{customer.lastName}</td>
                                    <td>{customer.primaryContact}</td>
                                    <td>{customer.secondaryContact}</td>
                                    <td>{customer.primaryEmail}</td>
                                    <td>{customer.secondaryEmail}</td>
                                    <td>
                                        <button type="edit" className="btn btn-sm " title="Edit" style={{ cursor: "pointer" }} onClick={() => handleEditCustomer(customer)}><a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>&nbsp;
                                        <button type="delete" className="btn btn-sm " title="Delete" style={{cursor: "pointer"}} onClick={() => handleDeleteCustomer(customer.customerId)}><a href="#"><i class="fa fa-trash" aria-hidden="true"></i></a></button>&nbsp;
                                        <button type="ACTIVATE" className="btn btn-sm "  title="Activate" style={{cursor: "pointer"}} onClick={() => activateCustomer(customer.customerId)}><a href="#"><i class="fa fa-check" aria-hidden="true"></i></a></button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                ) : (
                    <p className="text-center text-muted">No customers found.</p>
                )}
            </div>
            {/* Edit Customer Modal */}
            <Modal show={showModal} onHide={() => setShowModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit Customer</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    {selectedCustomer && (
                        <Form onSubmit={handleUpdateCustomer}>
                            <Form.Group className="mb-3">
                                <Form.Label>First Name</Form.Label>
                                <Form.Control type="text" name="firstName" value={selectedCustomer.firstName} onChange={handleInputChange} />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Last Name</Form.Label>
                                <Form.Control type="text" name="lastName" value={selectedCustomer.lastName} onChange={handleInputChange} />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Primary Contact</Form.Label>
                                <Form.Control type="text" name="primaryContact" value={selectedCustomer.primaryContact} onChange={handleInputChange} />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Primary Email</Form.Label>
                                <Form.Control type="email" name="primaryEmail" value={selectedCustomer.primaryEmail} onChange={handleInputChange} />
                            </Form.Group>
                            <Button variant="primary" type="submit">Update</Button>
                        </Form>
                    )}
                </Modal.Body>
            </Modal>
        </div>
    );
}

export default CustomerList;

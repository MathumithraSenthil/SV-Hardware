import React, { useEffect, useState } from "react";
import { useParams, useHistory } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { Navigate, useNavigate } from "react-router-dom";
import Swal from 'sweetalert2';

function CreateOrder(){
 
    const { orderId } = useParams();

    const navigate = useNavigate();
    const [customers, setCustomers] = useState([]);   
    const [loading, setLoading] = useState(false); 
    const [isCustomerExists, setCustomerExists] = useState("");
  
    const [error, setError] = useState("");
    const [serviceCharges, setServiceCharges] = useState([]);
    const [customername, setcustomername] = useState("");
    const [operationtype, setoperationtype] = useState("");
    const [servicefor, setservicefor] = useState("");
    const [laptopmaker, setlaptopmaker] = useState("");
    const [servicetype, setservicetype] = useState("");
    const [problem, setproblem] = useState("");
    const [totalamount, settotalamount] = useState("")  ;
    const [advanceamount, setadvanceamount] = useState("");
    const [balanceamount, setbalanceamount] = useState("");
    const [paymentmode, setpaymentmode] = useState("");

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

    useEffect(() => {
       
        if (!orderId) return;
        const fetchOrderData = async () => {
            setLoading(true);
            try {
                const resp = await axios.get(
                    `http://localhost:9887/order/getOrderDetailsByOrderId?orderId=` + String(orderId)
                );  
                
                const customersList = await axios.get('http://localhost:9887/customer/getAllCustomer');
                setCustomers(customersList.data);
                const selectedCust = customersList.data.find(customer => customer.customerId === resp.data.customerId);
    
                if (selectedCust) {
                    const fullName = `${selectedCust.firstName} ${selectedCust.lastName}`;
                    //console.log("Selected Customer: ", fullName);
                    setcustomername(fullName);
                }
    
                // Set other order details in the form fields
                setoperationtype(resp.data.typeOfOperation);
                setservicefor(resp.data.serviceFor);
                setservicetype(resp.data.typeOfProblem);
                setlaptopmaker(resp.data.maker);
                settotalamount(resp.data.totalAmount);
                setadvanceamount(resp.data.advanceAmount);
                setbalanceamount(resp.data.balanceAmount);
                setproblem(resp.data.typeOfProblem);
                setpaymentmode(resp.data.paymentMode);
    
            } catch (error) {
               // console.error("Error fetching order or customers:", error);
                setError("Failed to load customer data.");
            } finally {
                setLoading(false);
            }
        };
    
        fetchOrderData(); 
    }, [orderId]); 
    
    function check(){
        if ( !operationtype || !servicefor || !laptopmaker || !servicetype || !totalamount || !advanceamount || !balanceamount || !paymentmode) {
            setError("All fields are required!");
            return;
          }
          else{
            CreateOrderPayLoad();
          }
         
      }

      useEffect(() => {
      
        
    }, []);

    function isExists(value){
        setCustomerExists(value);
        if(value==="yes"){
            fetchCustomer();
        }
        else{
           // Navigate("/create-customer");
        }
    }
    const fetchCustomer = async () =>{
        debugger;
        setLoading(true);
        try{
            const response = await axios.get('http://localhost:9887/customer/getAllCustomer');
            setCustomers(response.data); 
        }
        catch(error){
           // console.error("Error fetching customer:", error);
            setError("Failed to fetch customer. Please try again.");
        }
        finally {
            setLoading(false); 
        }
    }

    const SelectedCustomer = (event) => {
        const selectedCustomer = customers.find(customer => customer.customerId === event.target.value);
    
        if (selectedCustomer) {
            const fullName = `${selectedCustomer.firstName} ${selectedCustomer.lastName}`;
            //console.log("Selected Customer: ", fullName);
            setcustomername(fullName);
        }
    };

   const CreateOrderPayLoad= async()=>{
       
        const orderData = {
            customerId:customers[0].customerId,            
            orderId:orderId,
            typeOfOperation:operationtype ,
            serviceFor:servicefor,
            typeOfProblem:servicetype,
            maker:laptopmaker,
            totalAmount:totalamount,
            paymentMode:paymentmode,
            advanceAmount:advanceamount,
            balanceAmount:balanceamount,
        };
        console.log(orderData);

        try {
            const response = await axios.post('http://localhost:9887/order/saveOrder', orderData);
            successAlert('Order Created Successfully!');
           // console.log("Response:", response.data);
            navigate("/order-list");
            handleReset();
        } catch (error) {
           // console.error("Error creating order:", error);
           failure('Failed to create order!');
            setError("Failed to create order. Please try again.");
        }
    }
    
    const calculateAmount = () => {
        let total = 0;
        const laptop = serviceCharges.find(item => item.name === "Laptop")?.amount || 0;
        const desktop = serviceCharges.find(item => item.name === "Desktop")?.amount || 0;
        const problemCharge = serviceCharges.find(item => item.name === problem)?.amount || 0;
    
        if (servicefor === "laptop") {
            total = problemCharge + laptop;
        } else if (servicefor === "desktop") {
            total = problemCharge + desktop;
        }
        settotalamount(total);
    };
    
    useEffect(() => {
        calculateAmount();
    }, [servicefor, problem, serviceCharges]);
    

      useEffect(() => {
        //total amount calculation
        const total = parseFloat(totalamount) || 0;
        const advance = parseFloat(advanceamount) || 0;
        setbalanceamount(total - advance);
    }, [totalamount, advanceamount]);

    const handleCreateOrder = async (event) =>{
        event.preventDefault();
        check();

    };

   

    function handleReset(){
        setCustomerExists("")
        setcustomername("");
        setoperationtype("");
        setservicefor("");
        setlaptopmaker("");
        setservicetype("");
        settotalamount("");
        setadvanceamount("");
        setbalanceamount("");
    }

    const styles={
        card: { width: "600px",  background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"},
        
        select: {height: "40px", width: "243px"},
        button: {height: "40px"}
      };

    return(
        <div className="bg-primary-subtle">
        {/*Nav bar */}
        
        <div className="container vh-100 d-flex justify-content-center align-items-center ">
           <div className="card p-4" style={ styles.card}>
           <h2 className="text-center mb-4 text-white">
  {orderId? "Update Order" : "Create Order"}
</h2>
                <form onSubmit={handleCreateOrder}>
                
                <div class="row">
                    {/*Customer name*/}

                    
                    {!orderId && (
                    <div className="col justify-content-center align-items-center">
                        <label className="form-label text-white">Is customer exists</label><br />
                        <select className="form-select-sm" style={styles.select} onChange={(e) => isExists(e.target.value)}>
                        <option value="" disabled selected>Select</option>
                        <option value="yes">Yes</option>
                        <option value="no">No</option>
                        </select>
                    </div>
                    )}
                    
 
                    {isCustomerExists === 'yes' ? (
                    // Display dropdown when customer exists
                    <div className="col">
                        <label className="form-label text-white">Customer Name</label>
                        <select className="form-select-sm" style={styles.select} onChange={SelectedCustomer}>
                            <option value="">Select a Customer</option>
                            {customers.map((customerDto, index) => {
                                const fullName = `${customerDto.firstName} ${customerDto.lastName}`;
                                return (
                                    <option key={customerDto.customerId || index} value={customerDto.customerId}>
                                        {fullName}
                                    </option>
                                );
                            })}
                        </select>
                    </div>
                ) : customername  && orderId !=null ? (
                    // Display the customer name in a text input if customer name is available
                    <div className="col">
                        <label className="form-label text-white">Customer Name</label>
                        <input
                            type="text"
                            className="form-control"
                            value={customername}
                            disabled
                        />
                    </div>
                ) : null}

                    {/*Secondary Email*/}
                    <div class="col">
                    <label className="form-label text-white">Operation Type</label>
                    <br/>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example" 
                    value={operationtype} 
                    onChange={(e) => setoperationtype(e.target.value)} >
                        <option value="" disabled>Select Operation Type</option>
                        <option value="sales">Sales</option>
                        <option value="service">Service</option>
                    </select>
                    </div>
                </div>

                <div class="row">
                     {/*Service for*/}
                    <div class="col">
                    <label className="form-label text-white">Service for</label>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example" 
                    value={servicefor} 
                    onChange={(e) => setservicefor(e.target.value)} >
                        <option value="">Select Service For</option>
                        <option value="desktop">Desktop</option>
                        <option value="laptop">Laptop</option>
                    </select>
                    </div>

                     {/*Laptop maker*/}
                    <div class="col">
                    <label className="form-label text-white">Laptop maker</label>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example"  
                    value={laptopmaker} 
                    onChange={(e) => setlaptopmaker(e.target.value)}>
                        <option value="" disabled selected>Select Laptop Maker</option>
                        <option value="apple">apple</option>
                        <option value="lenovo">Lenovo</option>
                        <option value="dell">Dell</option>
                        <option value="hp">hp</option>
                        <option value="acer">acer</option>
                    </select>
                    </div>
                </div>
                
                <div class="row">
                     {/*Service type*/}
                    <div class="col">
                    <label className="form-label text-white">Service type</label>
                    <select class="form-select-sm mb-3" 
                    style={styles.select} 
                    aria-label="Large select example" 
                    value={servicetype} 
                    onChange={(e) => setservicetype(e.target.value)}>
                        <option value="" disabled selected>Select Service Type</option>
                        <option value="hardware">Hardware</option>
                        <option value="software">Software</option>
                    </select>
                    </div>
                     {/*Problem*/}
                        <div class="col">
                        <label className="form-label text-white">Type of Problem </label><br/>
                        <select 
                            className="form-select-sm mb-3" 
                            style={styles.select} 
                            aria-label="Large select example"  
                            value={problem} // Bind value to the problem state
                            onChange={(e) => setproblem(e.target.value)} >
                            <option value="" disabled>Select problem</option>
                            <option value="hardware" disabled={problem === "hardware"}>Hardware problem</option>
                            <option value="keyboard" disabled={problem === "keyboard"}>Keyboard problem</option>
                            <option value="screen" disabled={problem === "screen"}>Screen problem</option>
                            <option value="battery" disabled={problem === "battery"}>Battery problem</option>
                            <option value="camera" disabled={problem === "camera"}>Camera problem</option>
                            <option value="speaker" disabled={problem === "speaker"}>Speaker problem</option>
                        </select>


                    </div>  
                </div>

                <div class="row">
                    {/*Total Amount*/}
                    <div class="col"> 
                    <label className="form-label text-white" onClick={calculateAmount}>Total Amount</label>
                    <input 
                        type="number" 
                        className="form-control fst-italic" 
                        style={{width:"250px"}}
                        value={totalamount} 
                        onChange={(e) => {
                            settotalamount(e.target.value);
                          }}
                        required
                    />
                    </div>
                     {/*Advance Amount*/}
                    <div class="col">
                    <label className="form-label text-white">Advance Amount</label>
                    <input 
                        type="number" 
                        className="form-control fst-italic" 
                        style={{width:"250px"}}
                        value={advanceamount} 
                        onChange={(e) => {
                            setadvanceamount(e.target.value);
                          }} 
                        required
                    />
                    </div>
                </div>
               
                    <div class="row">
                        {/*Balance Amount*/}
                    <div class="col">
                    <label className="form-label mt-3 text-white" >Balance Amount</label>
                    <input 
                            type="number" 
                            className="form-control fst-italic" 
                            style={{width:"250px"}}
                            value={balanceamount} 
                            readOnly
                            />
                    </div>
                        {/*Payment mode*/}
                    <div class="col">
                    <label className="form-label mt-3 text-white">Payment Mode</label><br/>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example"  
                    value={paymentmode} 
                    onChange={(e) => setpaymentmode(e.target.value)}>
                        <option value="" disabled selected>Select Payment Mode</option>
                        <option value="cash">Cash</option>
                        <option value="upi">UPI</option>
                        <option value="instrument">Instrument</option>
                    </select>
                    </div>
                    </div>
                    {error && <p className="text-danger fs-5 fw-bolder">{error}</p>}   
                    <div class="col" className="d-flex justify-content-center" style={styles.button}>
                        <button class="btn btn-primary me-md-2" type="button" onClick={check}>{orderId? "Update" : "Create"}</button>
                        <button class="btn btn-primary" type="button" onClick={handleReset}>Cancel</button>
                    </div>            
                </form>
           </div>
        </div>
     </div>
    );
}
export default CreateOrder

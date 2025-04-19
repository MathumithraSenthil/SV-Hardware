package sv.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.dto.CustomerDto;
import sv.infotech.dto.OrderDto;
import sv.infotech.service.CustomerService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);
	}

	@GetMapping("/getAllCustomer")
	public ResponseEntity<?> getAllCustomerDto() {
		return customerService.displayCustomer();
	}

	@PostMapping("/deleteCustomer")
	public ResponseEntity<?> deleteCustomer(@RequestParam String customerId){
		return customerService.deleteCustomer(customerId);
	}
	
	@PostMapping("/activateOrDeactivateCustomer") 
	public ResponseEntity<String> activateOrDeactivateCustomer(@RequestParam String customerId) {	
		return customerService.activateOrDeactivateCustomer(customerId);
	}
	
	
}

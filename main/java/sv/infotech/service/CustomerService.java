package sv.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import sv.infotech.dto.CustomerDto;

public interface CustomerService {

	public ResponseEntity<String> createCustomer(CustomerDto customerDto);

	public ResponseEntity<?> displayCustomer();

	public ResponseEntity<?> deleteCustomer(String customerId);

	public ResponseEntity<String> activateOrDeactivateCustomer(String customerId);


}

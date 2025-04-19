package sv.infotech.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.dto.CustomerDto;
import sv.infotech.entity.Customer;
import sv.infotech.repository.ICustomerRepository;
import sv.infotech.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	public ResponseEntity<String> createCustomer(CustomerDto customerDto) {
		String response = null;
		if (customerDto != null) {
			Customer customer = null;
			// update
			if (customerDto.getCustomerId() != null) {
				customer = customerRepository.findByCustomerId(Integer.parseInt(customerDto.getCustomerId()));

				if (customer != null) {
					customer.setCustomerId(Integer.parseInt(customerDto.getCustomerId()));
					customer.setSurname(customerDto.getSurname());
					customer.setFirstName(customerDto.getFirstName());
					customer.setMiddleName(customerDto.getMiddleName());
					customer.setLastName(customerDto.getLastName());
					customer.setPrimaryContact(customerDto.getPrimaryContact());
					customer.setSecondaryContact(customerDto.getSecondaryContact());
					customer.setPrimaryEmail(customerDto.getPrimaryEmail());
					customer.setSecondaryEmail(customerDto.getSecondaryEmail());
					customerRepository.save(customer);

				}
				response = "Customer details updated successfully";
			} else {
				// create customer
				customer = new Customer();
				customer.setSurname(customerDto.getSurname());
				customer.setFirstName(customerDto.getFirstName());
				customer.setMiddleName(customerDto.getMiddleName());
				customer.setLastName(customerDto.getLastName());
				customer.setPrimaryContact(customerDto.getPrimaryContact());
				customer.setSecondaryContact(customerDto.getSecondaryContact());
				customer.setPrimaryEmail(customerDto.getPrimaryEmail());
				customer.setSecondaryEmail(customerDto.getSecondaryEmail());
				customer.setIsActive("Y");
				customer.setIsDelete("N");
				customerRepository.save(customer);
				response = "New customer created successfully";
			}

		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> displayCustomer() {

		List<Customer> customer = customerRepository.findByIsDelete("N");
		List<CustomerDto> customerDto = new ArrayList<>();
		ResponseEntity<?> resp = null;
		if (customer != null) {
			for (Customer customer1 : customer) {
				CustomerDto customerDto1 = new CustomerDto();
				customerDto1.setCustomerId(Integer.toString(customer1.getCustomerId()));
				customerDto1.setSurname(customer1.getSurname());
				customerDto1.setFirstName(customer1.getFirstName());
				customerDto1.setMiddleName(customer1.getMiddleName());
				customerDto1.setLastName(customer1.getLastName());
				customerDto1.setPrimaryContact(customer1.getPrimaryContact());
				customerDto1.setSecondaryContact(customer1.getSecondaryContact());
				customerDto1.setPrimaryEmail(customer1.getPrimaryEmail());
				customerDto1.setSecondaryEmail(customer1.getSecondaryEmail());
				customerDto.add(customerDto1);
			}
			resp = new ResponseEntity<List<CustomerDto>>(customerDto, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("no customer data found", HttpStatus.OK);
		}

		return resp;
	}

	// GET Customer Details ByName

	public ResponseEntity<?> CustomerDetailsByName(CustomerDto customerDto) {
		ResponseEntity<?> resp = null;
		List<Customer> customerList = customerRepository.findBySurnameAndFirstNameAndMiddleNameAndLastName(
				customerDto.getSurname(), customerDto.getFirstName(), customerDto.getMiddleName(),
				customerDto.getLastName());

		if (customerList != null) {
			List<CustomerDto> customerList1 = new ArrayList<>();

			for (CustomerDto customer : customerList1) {
				CustomerDto dto = new CustomerDto();
				dto.setCustomerId(customer.getCustomerId());
				dto.setSurname(customer.getSurname());
				dto.setFirstName(customer.getFirstName());
				dto.setMiddleName(customer.getMiddleName());
				dto.setLastName(customer.getLastName());
				dto.setPrimaryContact(customer.getPrimaryContact());
				dto.setSecondaryContact(customer.getSecondaryContact());
				dto.setPrimaryEmail(customer.getPrimaryEmail());
				dto.setSecondaryEmail(customer.getSecondaryEmail());
				customerList1.add(dto);
			}
			resp = new ResponseEntity<>(customerDto, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<>("No customer data found", HttpStatus.NOT_FOUND);
		}

		return resp;
	}

//write a new metgid from contoller 
	public ResponseEntity<?> deleteCustomer(String CustomerId) {
		ResponseEntity<String> resp = null;
		if (CustomerId != null) {
			Customer customer = customerRepository.findByCustomerId(Integer.parseInt(CustomerId));
			if (customer != null && "Y".equals(customer.getIsActive())) {	
				customer.setIsDelete("Y");
			}
			customerRepository.save(customer);
			resp = new ResponseEntity<String>("Customer Deleted Successfully", HttpStatus.OK);
		}
		return resp;
	}

	@Override
	public ResponseEntity<String> activateOrDeactivateCustomer(String customerId) {
		String respData = null;
		Customer customer = customerRepository.findByCustomerId(Integer.parseInt(customerId));
		if (customer != null && "Y".equals(customer.getIsActive())) {
			customer.setIsActive("N");
			respData = "Customer is DeActivated";
		} else {
			customer.setIsActive("Y");
			respData = "Customer is Activated";
		}
		customerRepository.save(customer);
		return new ResponseEntity<String>(respData, HttpStatus.OK);
	}

}

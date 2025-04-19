package sv.infotech.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import sv.infotech.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByCustomerId(Integer CustomerId);

	List<Customer> findBySurname(String surname);

	List<Customer> findBySurnameAndFirstNameAndMiddleNameAndLastName(String surname, String firstName,
			String middleName, String lastName);

	List<Customer> findByIsDelete(String deleted);
	
	@Query(value = "Select count(cus_id) from Customer", nativeQuery = true)
	public Integer countTotalCustomer();
	
	@Query(value ="select count(cus_id) from Customer where is_active='Y'", nativeQuery = true)
	public int countActiveCustomer();
}

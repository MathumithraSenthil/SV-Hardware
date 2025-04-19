package sv.infotech.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface DashBoardService {

	ResponseEntity<Integer> countTotalOrder();

	ResponseEntity<Integer> countTotalCustomer();

	ResponseEntity<Integer> countActiveCustomer();

	ResponseEntity<Integer> countDeliveredOrder();

	ResponseEntity<Integer> countCashPaymentMode();

	ResponseEntity<Integer> countInsrtrumentPaymentMode();

	ResponseEntity<Integer> countUpiPaymentMode();
	
	

}

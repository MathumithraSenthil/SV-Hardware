package sv.infotech.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.service.DashBoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/dashboard")
public class DashBoardRestController {

	@Autowired
	public DashBoardService dashBoardService;
	
	@GetMapping("/countTotalCustomer")
	public ResponseEntity<Integer> countTotalCustomer() {
		return dashBoardService.countTotalCustomer();
	}
	
	@GetMapping("/countActiveCustomer")
	public ResponseEntity<Integer> countActiveCustomer() {
		return dashBoardService.countActiveCustomer();
	}
	
	@GetMapping("/countTotalOrder")
	public ResponseEntity<Integer> countTotalOrder() {
		return dashBoardService.countTotalOrder();
	}
	
	@GetMapping("/countDeliveredOrder")
	public ResponseEntity<Integer> countDeliveredOrder() {
		return dashBoardService.countDeliveredOrder();
	}
	
	@GetMapping("/countCashPaymentMode")
	public ResponseEntity<Integer> countCashPaymentMode() {
		return dashBoardService.countCashPaymentMode();
	}
	
	@GetMapping("/countInsrtrumentPaymentMode")
	public ResponseEntity<Integer> countInsrtrumentPaymentMode() {
		return dashBoardService.countInsrtrumentPaymentMode();
	}
	
	@GetMapping("/countUpiPaymentMode")
	public ResponseEntity<Integer> countUpiPaymentMode() {
		return dashBoardService.countUpiPaymentMode();
	}
	
}

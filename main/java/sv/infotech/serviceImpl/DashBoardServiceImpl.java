package sv.infotech.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.repository.ICustomerRepository;
import sv.infotech.repository.IOrderRepository;
import sv.infotech.service.DashBoardService;

@Service
public class DashBoardServiceImpl implements DashBoardService {

	@Autowired
	public ICustomerRepository customerRepository;

	@Autowired
	public IOrderRepository orderRepository;

	@Override
	public ResponseEntity<Integer> countTotalCustomer() {
		int count = customerRepository.countTotalCustomer();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> countActiveCustomer() {
		int count = customerRepository.countActiveCustomer();
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> countTotalOrder() {
		int count = orderRepository.countTotalOrder();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> countDeliveredOrder() {
		int count=orderRepository.countDeliveredOrder();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> countCashPaymentMode() {
		int count=orderRepository.countCashPaymentMode();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> countInsrtrumentPaymentMode() {
		int count=orderRepository.countInsrtrumentPaymentMode();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> countUpiPaymentMode() {
		int count=orderRepository.countUpiPaymentMode();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
}

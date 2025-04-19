package sv.infotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/**
 * @author mathu
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.dto.OrderDto;
import sv.infotech.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/saveOrder")
	public ResponseEntity<String> saveOrder(@RequestBody OrderDto orderDto) {
		return orderService.CreateOrder(orderDto);
	}

	@GetMapping("/getAllOrdersList")
	public ResponseEntity<?> getAllOrdersList() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/getOrderDetailsByOrderId")
	public ResponseEntity<OrderDto> getOrderDetailsByOrderId(@RequestParam String orderId){
		return orderService.getOrderDetailsByOrderId(orderId);
	}
	
	@PostMapping("/deliverOrder")
	public ResponseEntity<?> deliverOrder(@RequestParam String orderId) {
		
		return orderService.deliverOrder(orderId);
	}
	
	@GetMapping("/displayDeliveredOrders")
	public ResponseEntity<?> displayDeliveredOrders() {
		return orderService.displayDeliveredOrders();
	}
	
}

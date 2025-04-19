package sv.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import sv.infotech.dto.OrderDto;

public interface OrderService {

	public ResponseEntity<String> CreateOrder(OrderDto orderDto);

	public ResponseEntity<?> getAllOrders();

	public ResponseEntity<OrderDto> getOrderDetailsByOrderId(String orderId);

	

	ResponseEntity<?> deliverOrder(String orderId);

	public ResponseEntity<?> displayDeliveredOrders();


	
	

}

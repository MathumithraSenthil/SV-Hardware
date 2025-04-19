package sv.infotech.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.dto.CustomerDto;
import sv.infotech.dto.OrderDto;
import sv.infotech.entity.Constant;
import sv.infotech.entity.Order;
import sv.infotech.mailSender.AppMailSender;
import sv.infotech.repository.IOrderRepository;
import sv.infotech.repository.InstrumentRepository;
import sv.infotech.repository.IupiRepository;
import sv.infotech.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	// Auto wiring Repository
	@Autowired
	private AppMailSender appMailSender;

	@Autowired
	private IOrderRepository orderRepository;

	// Create Order

	public ResponseEntity<String> CreateOrder(OrderDto orderDto) {
		String response = null;

		if (orderDto != null) {
			Order order = null;

			if (orderDto.getOrderId() != null) {
				order = orderRepository.findByOrderId(Integer.parseInt(orderDto.getOrderId()));
				// update order
				if (order != null) {
					order.setOrderId(Integer.parseInt(orderDto.getOrderId()));
					order.setTypeOfOperation(orderDto.getTypeOfOperation());
					order.setServiceFor(orderDto.getServiceFor());
					order.setMaker(orderDto.getMaker());
					order.setOnService("Y");
					order.setIsOrderDeliverd("N");
				}
				orderRepository.save(order);
				response = "Order updated";

			} else {
				// creating order
				order = new Order();
				order.setCustomerId(Integer.parseInt(orderDto.getCustomerId()));
				order.setTypeOfOperation(orderDto.getTypeOfOperation());
				order.setServiceFor(orderDto.getServiceFor());
				order.setMaker(orderDto.getMaker());
				order.setTotalAmount(orderDto.getTotalAmount());
				order.setPaymentMode(paymentMode(orderDto.getPaymentMode()));
				order.setAdvanceAmount(orderDto.getAdvanceAmount());
				order.setBalanceAmount(orderDto.getBalanceAmount());
				order.setTypeOfProblem(orderDto.getTypeOfProblem());
				order.setOnService("Y");
				order.setIsOrderDeliverd("N");
				orderRepository.save(order);
				response = "Order created";
				//appMailSender.sendOrderEmail(new CustomerDto(),new OrderDto(),new FileSystemResource(new File(response)) ,response);
			}
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// displaying the order which are note delivered

	public ResponseEntity<List<OrderDto>> displayOrders() {

		List<Order> order = orderRepository.findByIsOrderDeliverd("N");
		List<OrderDto> orderDto = new ArrayList<>();

		for (Order order1 : order) {
			OrderDto orderDto2 = new OrderDto();
			orderDto2.setOrderId(Integer.toString(order1.getOrderId()));
			orderDto2.setTypeOfOperation(order1.getTypeOfOperation());
			orderDto2.setTypeOfProblem(order1.getTypeOfProblem());
			orderDto2.setMaker(order1.getMaker());
			orderDto2.setTotalAmount(order1.getTotalAmount());
			orderDto2.setPaymentMode(order1.getPaymentMode());
			orderDto.add(orderDto2);
		}
		return new ResponseEntity<>(orderDto, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> getAllOrders() {
		List<Order> orders = orderRepository.findByIsOrderDeliverdAndOnService("N", "Y");
		ResponseEntity<?> resp = null;
		if (orders != null && !orders.isEmpty()) {
			List<OrderDto> orderDto = new ArrayList<>();
			for (Order order : orders) {
				OrderDto dto = new OrderDto();
				dto.setOrderId(String.valueOf(order.getOrderId()));
				dto.setTypeOfOperation(order.getTypeOfOperation());
				dto.setServiceFor(order.getServiceFor());
				dto.setMaker(order.getMaker());
				dto.setTypeOfProblem(order.getTypeOfProblem());
				dto.setTypeOfProblem(order.getTypeOfProblem());
				dto.setTotalAmount(order.getTotalAmount());
				dto.setBalanceAmount(order.getBalanceAmount());
				dto.setAdvanceAmount(order.getAdvanceAmount());
				dto.setPaymentMode(order.getPaymentMode());
				orderDto.add(dto);
			}
			resp = new ResponseEntity<List<OrderDto>>(orderDto, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("No orders found", HttpStatus.OK);
		}

		return resp;
	}

	@Override
	public ResponseEntity<OrderDto> getOrderDetailsByOrderId(String orderId) {
		ResponseEntity<OrderDto> resp = null;
		OrderDto orderDto = null;
		if (orderId != null) {
			Order order = orderRepository.findByOrderId(Integer.parseInt(orderId));
			if (order != null) {
				orderDto = new OrderDto();
				orderDto.setOrderId(String.valueOf(order.getOrderId()));
				orderDto.setCustomerId(String.valueOf(order.getCustomerId()));
				orderDto.setTypeOfOperation(order.getTypeOfOperation());
				orderDto.setServiceFor(order.getServiceFor());
				orderDto.setAdvanceAmount(order.getAdvanceAmount());
				orderDto.setBalanceAmount(order.getBalanceAmount());
				orderDto.setTotalAmount(order.getTotalAmount());
				orderDto.setPaymentMode(order.getPaymentMode());
				orderDto.setTypeOfProblem(order.getTypeOfProblem());
				orderDto.setMaker(order.getMaker());
			}
			resp = new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
		}

		return resp;
	}
	
	// delivering orders
	
	@Override
	public ResponseEntity<?> deliverOrder(String orderId) {
		ResponseEntity<String> resp = null;
		
		if(orderId!=null) {
			Order order = orderRepository.findByOrderId(Integer.parseInt(orderId));
			if (order != null && "N".equals(order.getIsOrderDeliverd())) {
				order.setOnService("N");
				order.setIsOrderDeliverd("Y");
				orderRepository.save(order);
				resp = new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
			}

		}
		return resp;
	}
	
	//displaydelivered customers.
	@Override
	public ResponseEntity<?> displayDeliveredOrders() {
		ResponseEntity<?> resp=null;
		List<Order> order = orderRepository.findByIsOrderDeliverdAndOnService("Y", "N");;
		List<OrderDto> orderDto= new ArrayList<>();
		if(order!=null) {
			for (Order orders:order ) {
				OrderDto dto=new OrderDto();
				dto.setOrderId(String.valueOf(orders.getOrderId()));
				dto.setCustomerId(String.valueOf(orders.getCustomerId()));
				dto.setTypeOfOperation(orders.getTypeOfOperation());
				dto.setServiceFor(orders.getServiceFor());
				dto.setAdvanceAmount(orders.getAdvanceAmount());
				dto.setBalanceAmount(orders.getBalanceAmount());
				dto.setTotalAmount(orders.getTotalAmount());
				dto.setTypeOfProblem(orders.getTypeOfProblem());
				dto.setPaymentMode(orders.getPaymentMode());
				dto.setMaker(orders.getMaker());
				orderDto.add(dto);
			}
			resp =new ResponseEntity<List<OrderDto>>(orderDto,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("No orders found.",HttpStatus.OK);
		}
		return resp;
	}

	// Payment mode

	private String paymentMode(String paymentMode) {
		int payMode = 0;
		if (paymentMode.equalsIgnoreCase(Constant.CASH_MODE)) {
			payMode = 1;
		} else if (paymentMode.equalsIgnoreCase(Constant.INSTRUMENT_MODE)) {
			payMode = 2;
		} else if (paymentMode.equalsIgnoreCase(Constant.UPI_MODE)) {
			payMode = 3;
		}
		return String.valueOf(payMode);
	}

	

}
package sv.infotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sv.infotech.entity.Order;



public interface IOrderRepository extends JpaRepository<Order, Integer> {

	
	Order findByOrderId(int orderId);
	 
	List<Order> findByIsOrderDeliverd(String IsOrderDeliverd);

	List<Order> findByIsOrderDeliverdAndOnService(String isOrderDelieverd,String onService);

	@Query(value="select count(oid) from order_table", nativeQuery = true)
	public int countTotalOrder();
	
	@Query(value = "select count(oid) from order_table where order_status='Y'", nativeQuery = true)
	public int countDeliveredOrder();

	@Query(value="select count(oid) from order_table where pay_mode=1", nativeQuery = true)
	public int countCashPaymentMode();
	
	@Query(value="select count(oid) from order_table where pay_mode=2",nativeQuery = true)
	public int countInsrtrumentPaymentMode();
	
	@Query(value="select count(oid) from order_table where pay_mode=3", nativeQuery = true)
	public int countUpiPaymentMode();
}

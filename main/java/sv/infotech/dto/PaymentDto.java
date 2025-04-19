package sv.infotech.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import sv.infotech.entity.User;
import sv.infotech.entity.Order;

public class PaymentDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int paymentId;
	private User client;
	private Order order;
	private String paymentMethod;
	private LocalDateTime paymentTime;
	private String paymentStatus;
	private int totalAmount;
	private int advanceAmount;
	private int balanceAMount;

	//const,setters,getters,toString
	public PaymentDto() {
		super();
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(int advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public int getBalanceAMount() {
		return balanceAMount;
	}
	public void setBalanceAMount(int balanceAMount) {
		this.balanceAMount = balanceAMount;
	}
	@Override
	public String toString() {
		return "PaymentDto [paymentId=" + paymentId + ", client=" + client + ", order=" + order + ", paymentMethod="
				+ paymentMethod + ", paymentTime=" + paymentTime + ", paymentStatus=" + paymentStatus + ", totalAmount="
				+ totalAmount + ", advanceAmount=" + advanceAmount + ", balanceAMount=" + balanceAMount + "]";
	}
	
	
}

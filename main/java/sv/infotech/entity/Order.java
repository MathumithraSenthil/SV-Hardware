package sv.infotech.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private Integer orderId;

	@Column(name="cid")
	private Integer customerId;

	@Column(name = "operation")
	private String typeOfOperation;
	
	@Column(name="service_for")
	private String serviceFor;

	@Column(name = "adv_amount")
	private int advanceAmount;
	
	@Column(name = "bal_amount")
	private int balanceAmount;

	@Column(name="ser_charge_id")
	 private String serviceCharges;
	
	@Column(name = "problem")
	private String typeOfProblem;

	@Column(name = "maker")
	private String maker;

	@Column(name = "total_amount")
	private int totalAmount;

	@Column(name = "pay_mode")
	private String paymentMode;

	@Column(name="service_status")
	private String onService;
	
	@Column(name="order_status")
	private String isOrderDeliverd;

	public Order() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getTypeOfOperation() {
		return typeOfOperation;
	}

	public void setTypeOfOperation(String typeOfOperation) {
		this.typeOfOperation = typeOfOperation;
	}

	public String getServiceFor() {
		return serviceFor;
	}

	public void setServiceFor(String serviceFor) {
		this.serviceFor = serviceFor;
	}

	public String getTypeOfProblem() {
		return typeOfProblem;
	}

	public void setTypeOfProblem(String typeOfProblem) {
		this.typeOfProblem = typeOfProblem;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String complaint) {
		this.maker = complaint;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(int advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getOnService() {
		return onService;
	}

	public void setOnService(String onService) {
		this.onService = onService;
	}

	public String getIsOrderDeliverd() {
		return isOrderDeliverd;
	}

	public void setIsOrderDeliverd(String isOrderDeliverd) {
		this.isOrderDeliverd = isOrderDeliverd;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", typeOfOperation=" + typeOfOperation
				+ ", serviceFor=" + serviceFor + ", typeOfProblem=" + typeOfProblem + ", maker=" + maker + ", totalAmount="
				+ totalAmount + ", paymentMode=" + paymentMode + ", advanceAmount=" + advanceAmount + ", balanceAmount="
				+ balanceAmount + ", onService=" + onService + ", isOrderDeliverd=" + isOrderDeliverd + "]";
	}

	
}

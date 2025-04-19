package sv.infotech.dto;

import java.io.Serializable;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String orderId;
	private String customerId;
	private String typeOfOperation;
	private String serviceFor;
	private String typeOfProblem;
	private String maker;
	private int totalAmount;
	private String paymentMode;
	private int advanceAmount;
	private int balanceAmount;
	public OrderDto() {
		super();
	}
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", customerId=" + customerId + ", typeOfOperation=" + typeOfOperation
				+ ", serviceFor=" + serviceFor + ", typeOfProblem=" + typeOfProblem + ", maker=" + maker
				+ ", totalAmount=" + totalAmount + ", paymentMode=" + paymentMode + ", advanceAmount=" + advanceAmount
				+ ", balanceAmount=" + balanceAmount + "]";
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
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
	public void setMaker(String maker) {
		this.maker = maker;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

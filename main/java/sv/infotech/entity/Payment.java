package sv.infotech.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_table")
public class Payment {
	
	@Id
	@Column(name="pay_id")
	private int paymentId;
	
	@OneToOne
	@JoinColumn(name="cid")
	private User client;
	
	@OneToOne
	@JoinColumn(name="oid")
	private Order orderId;
	
	@Column(name="pay_method")
	private String paymentMethod;
	
	@Column(name="pay_time")
	private LocalDateTime paymentTime;
	
	@Column(name="pay_status")
	private String paymentStatus;
	
	@Column(name="tot_amnt")
	private int totalAmount;
	
	@Column(name="adv_amnt")
	private int advanceAmount;
	
	@Column(name="bal_amnt")
	private int balanceAMount;


	//const,setters,getters,toString
	public Payment() {
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

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
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
		return "Payment [paymentId=" + paymentId + ", client=" + client + ", orderId=" + orderId + ", paymentMethod="
				+ paymentMethod + ", paymentTime=" + paymentTime + ", paymentStatus=" + paymentStatus + ", totalAmount="
				+ totalAmount + ", advanceAmount=" + advanceAmount + ", balanceAMount=" + balanceAMount + "]";
	}
	
	
}

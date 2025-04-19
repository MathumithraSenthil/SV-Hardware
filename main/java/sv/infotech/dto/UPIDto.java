package sv.infotech.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class UPIDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String upiId;
	private int transactionId;
	private LocalDate transactionDate;
	private String transactionStatus;
	
	//const,setters,getters,toString
	public UPIDto() {
		super();
	}
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	@Override
	public String toString() {
		return "UPIDto [upiId=" + upiId + ", transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionStatus=" + transactionStatus + "]";
	}
	
}

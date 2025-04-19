package sv.infotech.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="upi_table")
public class Upi {

	@Id
	@Column(name="upi_id")
	private int upiId;
			
	@Column(name="tran_id")
	private int transactionId;
	
	@Column(name="tran_date")
	private LocalDate transactionDate;
	
	@Column(name="status")
	private String transactionStatus;

	@Override
	public String toString() {
		return "Upi []";
	}

	public int getUpiId() {
		return upiId;
	}

	public void setUpiId(int upiId) {
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

	
}

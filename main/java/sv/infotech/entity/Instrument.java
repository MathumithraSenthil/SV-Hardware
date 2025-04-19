package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instrument_table")
public class Instrument {

	@Id
	@Column(name="ins_id")
	private int instrumentId;
		
	@Column(name="cheque_num")
	private int chequeNumber;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="branch")
	private String bankBranch;
	
	@Column(name="status")
	private String paymentStatus;

	public Instrument() {
		super();
	}

	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public int getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(int chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Instrument [instrumentId=" + instrumentId + ", chequeNumber=" + chequeNumber + ", bankName=" + bankName
				+ ", bankBranch=" + bankBranch + ", paymentStatus=" + paymentStatus + "]";
	}

	
}

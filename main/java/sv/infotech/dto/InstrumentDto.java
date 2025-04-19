package sv.infotech.dto;

import java.io.Serializable;

public class InstrumentDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String instrumentId;
	private int chequeNumber;
	private String bankName;
	private String bankBranch;
	private String paymentStatus;
	
	//const,setters,getters,toString
	public InstrumentDto() {
		super();
	}
	public String getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(String instrumentId) {
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
		return "InstrumentDto [instrumentId=" + instrumentId + ", chequeNumber=" + chequeNumber + ", bankName="
				+ bankName + ", bankBranch=" + bankBranch + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}

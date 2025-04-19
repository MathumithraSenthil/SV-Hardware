package sv.infotech.dto;

import java.io.Serializable;

import jakarta.persistence.Column;

public class ServiceChargeDto implements Serializable{
	
	private int serviceChargeid;
	private String name;
	private int amount;

	//const,setters,getters,toString
	public ServiceChargeDto() {
		super();
	}

	public int getServiceChargeid() {
		return serviceChargeid;
	}

	public void setServiceChargeid(int serviceChargeid) {
		this.serviceChargeid = serviceChargeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ServiceChargeDto [serviceChargeid=" + serviceChargeid + ", name=" + name + ", amount=" + amount + "]";
	}
	
		
}

package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_charge")
public class ServiceCharge {

	@Id
	@Column(name = "ser_charge_id")
	private int serviceChargeid;
	@Column(name="ser_name")
	private String name;
	@Column(name="amount")
	private int amount;

	// const,setters,getters,toString
	public ServiceCharge() {
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
		return "ServiceCharge [serviceChargeid=" + serviceChargeid + ", name=" + name + ", amount=" + amount + "]";
	}

	
	
}

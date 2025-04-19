package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CLient_table")
public class User {
	@Id
	@Column(name="cid")
	private int clientId;
	@Column(name="c_fname")
	private String clientFirstName;
	@Column(name="c_lname")
	private String clientLastName;
	@Column(name="c_mail")
	private String clientMail;
	@Column(name="phn_no")
	private int phnNum;
	@Column(name="address")
	private String clientAddress;
	@Column(name="c_pwd")
	private String clientPassword;
	@Column(name="is_active")
	private String isActive="Y";
	@Column(name="is_delete")
	private String isDelete="N";
	
	public User() {
		super();
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

	public int getPhnNum() {
		return phnNum;
	}

	public void setPhnNum(int phnNum) {
		this.phnNum = phnNum;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientFirstName=" + clientFirstName + ", clientLastName="
				+ clientLastName + ", clientMail=" + clientMail + ", phnNum=" + phnNum + ", clientAddress="
				+ clientAddress + ", clientPassword=" + clientPassword + ", isActive=" + isActive + ", isDelete="
				+ isDelete + "]";
	}
	
	
	
	
	
	
}

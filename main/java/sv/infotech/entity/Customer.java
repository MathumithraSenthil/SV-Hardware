package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private int customerId;
	@Column(name = "sur_name")
	private String surname;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "mid_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "prim_contact")
	private String primaryContact;
	@Column(name = "sec_contact")
	private String secondaryContact;
	@Column(name = "prim_Email")
	private String primaryEmail;
	@Column(name = "sec_Email")
	private String secondaryEmail;
	@Column(name="isActive")
	private String isActive;
	@Column(name="isDelete")
	private String isDelete;

	
	// def const, setters/getters, toString
	public Customer() {
		super();
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPrimaryContact() {
		return primaryContact;
	}


	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}


	public String getSecondaryContact() {
		return secondaryContact;
	}


	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}


	public String getPrimaryEmail() {
		return primaryEmail;
	}


	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}


	public String getSecondaryEmail() {
		return secondaryEmail;
	}


	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
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
		return "Customer [customerId=" + customerId + ", surname=" + surname + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", primaryContact=" + primaryContact
				+ ", secondaryContact=" + secondaryContact + ", primaryEmail=" + primaryEmail + ", secondaryEmail="
				+ secondaryEmail + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
}

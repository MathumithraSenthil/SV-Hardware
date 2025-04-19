package sv.infotech.dto;

import java.io.Serializable;

import jakarta.persistence.Column;

public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String customerId;
	private String surname;
	private String firstName;
	private String middleName;
	private String lastName;
	private String primaryContact;
	private String secondaryContact;
	private String primaryEmail;
	private String secondaryEmail;
	private String isActive;
	private String isDelete;
	public CustomerDto() {
		super();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", surname=" + surname + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", primaryContact=" + primaryContact
				+ ", secondaryContact=" + secondaryContact + ", primaryEmail=" + primaryEmail + ", secondaryEmail="
				+ secondaryEmail + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
	
}

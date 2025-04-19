package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Supplier_table")
public class Supplier {
	@Id
	@Column(name="s_id")
	private int supplierId;
	@Column(name="s_name")
	private String supplierName;
	@Column(name="s_phn")
	private int phnNumber;
	@Column(name="s_mail")
	private String supplierMail;
	public Supplier() {
		super();
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getPhnNumber() {
		return phnNumber;
	}
	public void setPhnNumber(int phnNumber) {
		this.phnNumber = phnNumber;
	}
	public String getSupplierMail() {
		return supplierMail;
	}
	public void setSupplierMail(String supplierMail) {
		this.supplierMail = supplierMail;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", phnNumber=" + phnNumber
				+ ", supplierMail=" + supplierMail + "]";
	}
	
	
	
}

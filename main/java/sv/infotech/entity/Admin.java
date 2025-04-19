package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin_table")
public class Admin {
	@Id
	@Column(name="aid")
	private int adminId;
	@Column(name="a_name")
	private String adminName;
	@Column(name="a_pwd")
	private String adminPasword;
	@Column(name="a_mail")
	private String adminMailId;
	public Admin() {
		super();
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPasword() {
		return adminPasword;
	}
	public void setAdminPasword(String adminPasword) {
		this.adminPasword = adminPasword;
	}
	public String getAdminMailId() {
		return adminMailId;
	}
	public void setAdminMailId(String adminMailId) {
		this.adminMailId = adminMailId;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPasword=" + adminPasword
				+ ", adminMailId=" + adminMailId + "]";
	}
	
	
}

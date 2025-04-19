package sv.infotech.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="Staff_table")
public class Staff {
	@Id
	@Column(name="sid")
	private int staffId;
	@Column(name="s_name")
	private String staffName;
	@Column(name="s_pwd")
	private String staffPassword;
	@Column(name="s_age")
	private int staffAge;
	@Column(name="s_mail")
	private String staffMaild;
	@Column(name="phn_no")
	private int phnNumber;
	@Column(name="dept")
	private String department;
	@Column(name="sal")
	private int salary;
	@Column(name="joined_date")
	private LocalDate joinedDate;
	public Staff() {
		super();
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public int getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(int staffAge) {
		this.staffAge = staffAge;
	}
	public String getStaffMaild() {
		return staffMaild;
	}
	public void setStaffMaild(String staffMaild) {
		this.staffMaild = staffMaild;
	}
	public int getPhnNumber() {
		return phnNumber;
	}
	public void setPhnNumber(int phnNumber) {
		this.phnNumber = phnNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDate getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffPassword=" + staffPassword
				+ ", staffAge=" + staffAge + ", staffMaild=" + staffMaild + ", phnNumber=" + phnNumber + ", department="
				+ department + ", salary=" + salary + ", joinedDate=" + joinedDate + "]";
	}
	
	
}

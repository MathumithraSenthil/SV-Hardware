package sv.infotech.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="notification_table")
public class Notification {
	@Id
	@Column(name="nid")
	private int notificationId;
	
	@OneToMany
	@JoinColumn(name="aid")
	private Set<Admin> admin=new HashSet<>();
	
	@OneToMany
	@JoinColumn(name="pid")
	private Set<Payment> payment = new HashSet<>();
	
	@Column(name="status")
	private String paymentStatus;
}

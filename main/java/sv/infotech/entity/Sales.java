package sv.infotech.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sales_table")
public class Sales {

	@Id
	@Column(name="sal_id")
	private int salesId;
	
	@OneToOne
	@JoinColumn(name="cid")
	private User client;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Stock stock;
	
	@OneToOne
	@JoinColumn(name="sid")
	private Staff staff;
	
	@Column(name="pur_time")
	private LocalDateTime purchaseTime;
}

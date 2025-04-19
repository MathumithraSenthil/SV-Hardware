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
@Table(name="stock_table")
public class Stock {
 
	@Id
	@Column(name="pid")
	private int productId;
	
	@Column(name="p_name")
	private String productName;
	
	@Column(name="p_price")
	private double productPrice;
	
	@Column(name="qty")
	private int quantity;
	
	@OneToMany
	@JoinColumn(name="s_id")
	private Set<Supplier> Supplier = new HashSet<>();
}

package sv.infotech.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback_table")
public class Feedback {
	
	@Id
	@Column(name="fid")
	private int feedbackId;
	
	@OneToMany
	@JoinColumn(name="cid")
	private Set<User> client=new HashSet<>();
	
	@Column(name="fb_rating")
	private double rating;
	
	@Column(name="fb_comment")
	private String comment;
	
	@Column(name="fb_time")
	private LocalDate fbTime;
	
}

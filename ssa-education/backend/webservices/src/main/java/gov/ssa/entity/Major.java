package gov.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="major")
public class Major implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4730591621931799626L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="req_credits")
	private int req_credits;
	
	public Major() {}
	
	public Major(String name, String description, int req_credits) {
		super();
		this.name = name;
		this.description = description;
		this.req_credits = req_credits;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getReq_credits() {
		return req_credits;
	}

	public void setReq_credits(int req_credits) {
		this.req_credits = req_credits;
	}

}

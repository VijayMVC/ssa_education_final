package gov.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="major_class_relationship")
public class MajorClass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// Foreign key major_id
	@ManyToOne
	@JoinColumn(name="major_id")
	private Major major_id;
	
	// Foreign key class_id
	@ManyToOne
	@JoinColumn(name="class_id")
	private Class class_id;
	
	public MajorClass() {}

	public MajorClass(Major major_id, Class class_id) {
		super();
		this.major_id = major_id;
		this.class_id = class_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Major getMajor_id() {
		return major_id;
	}

	public void setMajor_id(Major major_id) {
		this.major_id = major_id;
	}

	public Class getClass_id() {
		return class_id;
	}

	public void setClass_id(Class class_id) {
		this.class_id = class_id;
	}
}

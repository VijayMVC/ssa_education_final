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
@Table(name="prerequisites")
public class Prerequisite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// Foreign key class_id
	@ManyToOne
	@JoinColumn(name="class_id")
	private Class class_id;
	
	// Foreign key prereq_class_id
	@ManyToOne
	@JoinColumn(name="prereq_class_id")
	private Class prereq_class_id;
	
	public Prerequisite() {}

	public Prerequisite(Class class_id, Class prereq_class_id) {
		super();
		this.class_id = class_id;
		this.prereq_class_id = prereq_class_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Class getClass_id() {
		return class_id;
	}

	public void setClass_id(Class class_id) {
		this.class_id = class_id;
	}

	public Class getPrereq_class_id() {
		return prereq_class_id;
	}

	public void setPrereq_class_id(Class prereq_class_id) {
		this.prereq_class_id = prereq_class_id;
	}	
}

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
@Table(name="class")
public class Class implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6420388931982631169L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// Foreign key first_semester
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department_id;
	
	@Column(name="num")
	private String num;
	
	@Column(name="name")
	private String name;
	
	@Column(name="credits")
	private int credits;
	
	@Column(name="description")
	private String description;
	
	public Class() {}

	public Class(Department department_id, String num, String name, int credits, String description) {
		super();
		this.department_id = department_id;
		this.num = num;
		this.name = name;
		this.credits = credits;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Department department_id) {
		this.department_id = department_id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

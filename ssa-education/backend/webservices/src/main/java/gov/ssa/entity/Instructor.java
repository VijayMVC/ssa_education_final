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
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="year_hired")
	private int year_hired;
	
	@Column(name="is_tenured")
	private int is_tenured;
	
	// Foreign key department_id
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department_id;

	public Instructor() {}

	public Instructor(String first_name, String last_name, int year_hired, int is_tenured, Department department_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.year_hired = year_hired;
		this.is_tenured = is_tenured;
		this.department_id = department_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getYear_hired() {
		return year_hired;
	}

	public void setYear_hired(int year_hired) {
		this.year_hired = year_hired;
	}

	public int getIs_tenured() {
		return is_tenured;
	}

	public void setIs_tenured(int is_tenured) {
		this.is_tenured = is_tenured;
	}

	public Department getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Department department_id) {
		this.department_id = department_id;
	}
}

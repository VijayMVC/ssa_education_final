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
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="gpa")
	private double gpa;
	
	// Foreign key first_semester
	@ManyToOne
	@JoinColumn(name="first_semester")
	private SchoolYear first_semester;
	
	// Foreign key major_id
	@ManyToOne
    @JoinColumn(name="major_id")
	Major major_id;
	
	// Foreign key account_id
	@ManyToOne
	@JoinColumn(name="account_id")
	Account account_id;
	
	public Student() {}
		
	public Student(String first_name, String last_name, double gpa, SchoolYear first_semester, Major major_id, Account account_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gpa = gpa;
		this.first_semester = first_semester;
		this.major_id = major_id;
		this.account_id = account_id;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public SchoolYear getFirst_semester() {
		return first_semester;
	}
	
	public void setFirst_semester(SchoolYear first_semester) {
		this.first_semester = first_semester;
	}
	
	public Major getMajor_id() {
		return major_id;
	}

	public void setMajor_id(Major major_id) {
		this.major_id = major_id;
	}

	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}	
}

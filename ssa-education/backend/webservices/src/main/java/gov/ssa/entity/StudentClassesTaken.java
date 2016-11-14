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
@Table(name="student_classes_taken")
public class StudentClassesTaken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// Foreign key student_id
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student_id;
	
	// Foreign key class_list_id
	@ManyToOne
	@JoinColumn(name="class_list_id")
	private ClassList class_list_id;
	
	@Column(name="grade")
	private String grade;
	
	public StudentClassesTaken() {}

	public StudentClassesTaken(Student student_id, ClassList class_list_id, String grade) {
		super();
		this.student_id = student_id;
		this.class_list_id = class_list_id;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Student student_id) {
		this.student_id = student_id;
	}

	public ClassList getClass_list_id() {
		return class_list_id;
	}

	public void setClass_list_id(ClassList class_list_id) {
		this.class_list_id = class_list_id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}

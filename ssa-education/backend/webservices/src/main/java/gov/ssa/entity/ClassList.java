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
@Table(name="class_list")
public class ClassList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private Class class_id;
	
	@Column(name="crn")
	private String crn;
	
	@Column(name="sect")
	private String sect;
	
	@ManyToOne
	@JoinColumn(name="semester")
	private SchoolYear semester;
	
	@ManyToOne
	@JoinColumn(name="classroom_id")
	private Classroom classroom_id;
	
	@Column(name="mon")
	private boolean mon;
	
	@Column(name="tues")
	private boolean tues;
	
	@Column(name="wed")
	private boolean wed;
	
	@Column(name="thurs")
	private boolean thurs;
	
	@Column(name="fri")
	private boolean fri;
	
	@Column(name="sat")
	private boolean sat;
	
	@Column(name="onl")
	private boolean onl;
	
	@ManyToOne
	@JoinColumn(name="instructor_id")
	private Instructor instructor_id;
	
	@Column(name="begin_time")
	private String begin_time;
	
	@Column(name="end_time")
	private String end_time;
	
	public ClassList() {}

	public ClassList(Class class_id, String crn, String sect, SchoolYear semester, Classroom classroom_id, boolean mon,
			boolean tues, boolean wed, boolean thurs, boolean fri, boolean sat, boolean onl, Instructor instructor_id,
			String begin_time, String end_time) {
		super();
		this.class_id = class_id;
		this.crn = crn;
		this.sect = sect;
		this.semester = semester;
		this.classroom_id = classroom_id;
		this.mon = mon;
		this.tues = tues;
		this.wed = wed;
		this.thurs = thurs;
		this.fri = fri;
		this.sat = sat;
		this.onl = onl;
		this.instructor_id = instructor_id;
		this.begin_time = begin_time;
		this.end_time = end_time;
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

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getSect() {
		return sect;
	}

	public void setSect(String sect) {
		this.sect = sect;
	}

	public SchoolYear getSemester() {
		return semester;
	}

	public void setSemester(SchoolYear semester) {
		this.semester = semester;
	}

	public Classroom getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(Classroom classroom_id) {
		this.classroom_id = classroom_id;
	}

	public boolean isMon() {
		return mon;
	}

	public void setMon(boolean mon) {
		this.mon = mon;
	}

	public boolean isTues() {
		return tues;
	}

	public void setTues(boolean tues) {
		this.tues = tues;
	}

	public boolean isWed() {
		return wed;
	}

	public void setWed(boolean wed) {
		this.wed = wed;
	}

	public boolean isThurs() {
		return thurs;
	}

	public void setThurs(boolean thurs) {
		this.thurs = thurs;
	}

	public boolean isFri() {
		return fri;
	}

	public void setFri(boolean fri) {
		this.fri = fri;
	}

	public boolean isSat() {
		return sat;
	}

	public void setSat(boolean sat) {
		this.sat = sat;
	}

	public boolean isOnl() {
		return onl;
	}

	public void setOnl(boolean onl) {
		this.onl = onl;
	}

	public Instructor getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(Instructor instructor_id) {
		this.instructor_id = instructor_id;
	}

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}	
}

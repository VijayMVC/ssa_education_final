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
@Table(name="classroom")
public class Classroom {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// foreign key building_id
	@ManyToOne
	@JoinColumn(name="building_id")
	private Building building_id;
	
	@Column(name="num")
	private String num;
	
	@Column(name="num_seats")
	private int num_seats;
		
	public Classroom() {}

	public Classroom(Building building_id, String num, int num_seats) {
		super();
		this.building_id = building_id;
		this.num = num;
		this.num_seats = num_seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Building getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(Building building_id) {
		this.building_id = building_id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getNum_seats() {
		return num_seats;
	}

	public void setNum_seats(int num_seats) {
		this.num_seats = num_seats;
	}
	
}

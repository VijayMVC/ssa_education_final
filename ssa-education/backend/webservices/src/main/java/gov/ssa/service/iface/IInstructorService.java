package gov.ssa.service.iface;

import java.util.List;

import gov.ssa.entity.Instructor;

public interface IInstructorService {
	List<Instructor> getAllInstructors();
	
	Instructor getInstructorById(int id);
	
	void addInstructor(Instructor instructor);
	
	void updateInstructor(Instructor instructor);
	
	void deleteInstructor(int id);
}

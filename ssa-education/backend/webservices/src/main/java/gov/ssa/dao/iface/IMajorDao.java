package gov.ssa.dao.iface;

import java.util.List;

import gov.ssa.entity.Class;
import gov.ssa.entity.Major;

public interface IMajorDao {
	List<Major> getAllMajors();
		
	Major getMajorById(int majorId);
	
	List<Class> getAllClassesForMajor(int id);
	
	List<Class> getClassesRemainingForMajor(int studentId);
	
	void addMajor(Major major);
	
	void updateMajor(Major major);
	
	void deleteMajor(int majorId);
}

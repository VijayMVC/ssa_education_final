package gov.ssa.service.iface;

import java.util.List;

import gov.ssa.entity.Class;

public interface IClassService {
	List<Class> getAllClasses();
	
	List<Class> getClassesByDepartment(int id);
	
	List<Class> getClassesByDepartmentCurrent(int id, int semester);
	
	List<Class> getClassesByStudentDepartmentCurrent(int departmentId, int studentId, int semester);
	
	Class getClassById(int id);
	
	void addClass(Class _class);
	
	void updateClass(Class _class);
	
	void deleteClass(int id);
}

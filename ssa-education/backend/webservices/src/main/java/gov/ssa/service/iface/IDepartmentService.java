package gov.ssa.service.iface;

import java.util.List;

import gov.ssa.entity.Department;

public interface IDepartmentService {
	List<Department> getAllDepartments();
	
	Department getDepartmentById(int id);
	
	void addDepartment(Department department);
	
	void updateDepartment(Department department);
	
	void deleteDepartment(int id);
}

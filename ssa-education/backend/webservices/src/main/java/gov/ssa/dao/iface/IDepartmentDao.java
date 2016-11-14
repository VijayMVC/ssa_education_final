package gov.ssa.dao.iface;

import java.util.List;

import gov.ssa.entity.Department;

public interface IDepartmentDao {
	List<Department> getAllDepartments();
	
	Department getDepartmentById(int id);
	
	void addDepartment(Department department);
	
	void updateDepartment(Department department);
	
	void deleteDepartment(int id);
}

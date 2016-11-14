package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.IDepartmentDao;
import gov.ssa.entity.Department;
import gov.ssa.service.iface.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {
	@Autowired
	private IDepartmentDao departmentDao;
	
	@Override
	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

	@Override
	public Department getDepartmentById(int id) {
		return departmentDao.getDepartmentById(id);
	}

	@Override
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);		
	}

	@Override
	public void deleteDepartment(int id) {
		departmentDao.deleteDepartment(id);		
	}
}

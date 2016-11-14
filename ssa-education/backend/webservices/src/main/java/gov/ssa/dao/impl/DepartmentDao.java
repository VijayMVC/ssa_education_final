package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IDepartmentDao;
import gov.ssa.entity.Department;

@Transactional
@Repository
public class DepartmentDao implements IDepartmentDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartments() {
		String hql = "from Department d order by d.id";		
		return (List<Department>) hibernateTemplate.find(hql);
	}

	@Override
	public Department getDepartmentById(int id) {
		String hql = "from Department where id = :id";
		return (Department) hibernateTemplate.findByNamedParam(hql, "id", id).get(0);
	}

	@Override
	public void addDepartment(Department department) {
		hibernateTemplate.save(new Department(department.getCode(),
				                              department.getName()));
	}

	@Override
	public void updateDepartment(Department department) {
		hibernateTemplate.update(department);		
	}

	@Override
	public void deleteDepartment(int id) {
		hibernateTemplate.delete(getDepartmentById(id));
	}
}

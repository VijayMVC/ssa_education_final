package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IClassListDao;
import gov.ssa.entity.ClassList;

@Transactional
@Repository
public class ClassListDao implements IClassListDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassList> getClassList() {
		String hql = "from ClassList cl order by cl.id";
		return (List<ClassList>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassList> getClassesBySemester(int semester) {
		String hql = "from ClassList cl where cl.semester.id = :semester order by cl.id";
		return (List<ClassList>) hibernateTemplate.findByNamedParam(hql, "semester", semester);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassList> getClassListByDepartment(int semester, int id) {
		String hql = "from ClassList cl where cl.class_id.department_id.id = :id and "
				+ "cl.semester.id = :semester order by cl.class_id.id, cl.sect";
		return (List<ClassList>) hibernateTemplate.findByNamedParam(hql, new String[] {"id", "semester"}, 
				new Object[] {id, semester});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClassList getClassByCRN(String crns) {
		String hql = "from ClassList cl where cl.crn = :crns";
		List <ClassList> cl = (List<ClassList>) hibernateTemplate.findByNamedParam(hql, "crns", crns);
		
		if(cl.size() > 0) {
			return cl.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassList> getSectionsOfClass(int semester, int id) {
		String hql = "from ClassList cl where class_id.id = :id and cl.semester.id = :semester order by cl.sect";		
		return (List<ClassList>) hibernateTemplate.findByNamedParam(hql, new String[] {"id", "semester"}, 
				new Object[] {id, semester});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassList> getSectionsOfClass(int semester, int department, String num) {
		String hql = "from ClassList cl where cl.class_id.department_id.id = :department and " + 
				"cl.semester.id = :semester and cl.class_id.num = :num order by cl.sect";		
		return (List<ClassList>) hibernateTemplate.findByNamedParam(hql, 
				new String[] {"semester", "department", "num"}, new Object[] {semester, department, num});
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClassList getClassListById(int id) {
		String hql = "from ClassList cl where id = :id";
		List<ClassList> cl = (List<ClassList>) hibernateTemplate.findByNamedParam(hql, "id", id);
		ClassList cl_entry;
		
		if(cl.size() > 0) {
			cl_entry = cl.get(0);
		} else {
			cl_entry = null;
		}
		
		return cl_entry;
	}

	@Override
	public void addClassList(ClassList cl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClassList(ClassList cl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClassList(int id) {
		// TODO Auto-generated method stub
		
	}	
}

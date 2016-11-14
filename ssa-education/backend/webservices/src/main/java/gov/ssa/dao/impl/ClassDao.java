package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IClassDao;
import gov.ssa.entity.Class;

@Transactional
@Repository
public class ClassDao implements IClassDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getAllClasses() {
		String hql = "from Class c order by c.id";		
		return (List<Class>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getClassesByDepartment(int id) {
		String hql = "from Class c where c.department_id.id= :id order by c.id";
		return (List<Class>) hibernateTemplate.findByNamedParam(hql, "id", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getClassesByDepartmentCurrent(int id, int semester) {
		String hql = "from Class c where c.department_id.id= :id and c.id in (" +
				"select cl.class_id.id from ClassList cl where cl.semester.id= :semester)";
		return (List<Class>) hibernateTemplate.findByNamedParam(hql,
				new String[] {"id", "semester"}, new Object[] {id, semester});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getClassesByStudentDepartmentCurrent(int departmentId, int studentId, int semester) {
		String hql = "from Class c where c.department_id.id= :departmentId and c.id in (" +
				"select cl.class_id.id from ClassList cl where cl.semester.id= :semester and c.id not in (" +
				"select sct.class_list_id.class_id.id from StudentClassesTaken sct where sct.student_id.id= :studentId" + 
				") and 0 = (" +
		
				"select count(*) from Prerequisite p where p.class_id.id = c.id and " +
				"p.prereq_class_id.id not in (" +
				"select p.prereq_class_id.id from StudentClassesTaken sct where sct.student_id.id= :studentId" +
				" and sct.class_list_id.semester.semester.id < :semester and "
				+ "sct.class_list_id.class_id.id = p.prereq_class_id.id)))";
		
		return (List<Class>) hibernateTemplate.findByNamedParam(hql, 
				new String[] {"departmentId", "studentId", "semester"},
				new Object[] {departmentId, studentId, semester});
	}

	@Override
	public Class getClassById(int id) {
		String hql = "from Class where id = :id";
		return (Class) hibernateTemplate.findByNamedParam(hql, "id", id).get(0);
	}

	@Override
	public void addClass(Class _class) {
		hibernateTemplate.save(new Class(_class.getDepartment_id(),
				                         _class.getNum(),
				                         _class.getName(),
				                         _class.getCredits(),
				                         _class.getDescription()));
	}

	@Override
	public void updateClass(Class _class) {
		hibernateTemplate.update(_class);		
	}

	@Override
	public void deleteClass(int id) {
		hibernateTemplate.delete(getClassById(id));
	}
}

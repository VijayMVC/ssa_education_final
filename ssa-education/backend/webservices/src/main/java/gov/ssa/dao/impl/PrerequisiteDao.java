package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.entity.Prerequisite;
import gov.ssa.dao.iface.IPrerequisiteDao;

@Transactional
@Repository
public class PrerequisiteDao implements IPrerequisiteDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Prerequisite> getAllPrerequisites() {
		String hql = "select p.prereq_class_id from Prerequisite p order by p.id";		
		return (List<Prerequisite>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Prerequisite> getPrerequisitesByClass(int id) {
		String hql = "select p.prereq_class_id from Prerequisite p where p.class_id.id = :id";
		return (List<Prerequisite>) hibernateTemplate.findByNamedParam(hql, "id", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Prerequisite> getPrerequisitesForStudent(int studentId, int classId, int semester) {
		String hql = "select p.prereq_class_id from Prerequisite p where p.class_id.id= :classId" +
				" and p.prereq_class_id not in (" +
				"select sct.class_list_id.class_id.id from StudentClassesTaken sct " +
				"where sct.student_id.id= :studentId and sct.class_list_id.semester.id< :semester)";
		return (List<Prerequisite>) hibernateTemplate.findByNamedParam(hql,
				new String[] {"studentId", "classId", "semester"}, new Object[] {studentId, classId, semester});
	}
}

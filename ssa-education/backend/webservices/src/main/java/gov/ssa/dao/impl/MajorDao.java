package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IMajorDao;
import gov.ssa.entity.Major;
import gov.ssa.entity.Class;

@Transactional
@Repository
public class MajorDao implements IMajorDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Major> getAllMajors() {
		String hql = "from Major m order by m.id";		
		return (List<Major>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getAllClassesForMajor(int id) {
		String hql = "select mc.class_id from MajorClass mc where mc.major_id.id = :id";
		return (List<Class>) hibernateTemplate.findByNamedParam(hql, "id", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getClassesRemainingForMajor(int studentId) {
		String hql = "select mc.class_id from MajorClass mc where mc.major_id.id=(" + 				
				"select s.major_id.id from Student s where s.id= :studentId" +
				") and mc.class_id.id not in (" +
				"select sct.class_list_id.class_id.id from StudentClassesTaken sct " +
				"where sct.student_id.id= :studentId)";
				
		return (List<Class>) hibernateTemplate.findByNamedParam(hql, "studentId", studentId);
	}

	@Override
	public Major getMajorById(int majorId) {
		String hql = "from Major where id = :majorId";
		return (Major) hibernateTemplate.findByNamedParam(hql, "majorId", majorId).get(0);
	}

	@Override
	public void addMajor(Major major) {
		hibernateTemplate.save(new Major(major.getName(),
										 major.getDescription(), 
										 major.getReq_credits()));
	}

	@Override
	public void updateMajor(Major major) {
		hibernateTemplate.update(major);		
	}

	@Override
	public void deleteMajor(int majorId) {
		hibernateTemplate.delete(getMajorById(majorId));
	}
}

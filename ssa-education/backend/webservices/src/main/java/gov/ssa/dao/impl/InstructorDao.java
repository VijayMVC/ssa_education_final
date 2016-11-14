package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IInstructorDao;
import gov.ssa.entity.Instructor;

@Transactional
@Repository
public class InstructorDao implements IInstructorDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Instructor> getAllInstructors() {
		String hql = "from Instructor i order by i.id";		
		return (List<Instructor>) hibernateTemplate.find(hql);
	}

	@Override
	public Instructor getInstructorById(int id) {
		String hql = "from Instructor where id = :id";
		return (Instructor) hibernateTemplate.findByNamedParam(hql, "id", id).get(0);
	}

	@Override
	public void addInstructor(Instructor instructor) {
		hibernateTemplate.save(new Instructor(instructor.getFirst_name(),
				                              instructor.getLast_name(),
				                              instructor.getYear_hired(),
				                              instructor.getIs_tenured(),
				                              instructor.getDepartment_id()));
	}

	@Override
	public void updateInstructor(Instructor instructor) {
		hibernateTemplate.update(instructor);		
	}

	@Override
	public void deleteInstructor(int id) {
		hibernateTemplate.delete(getInstructorById(id));
	}
}

package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.ISchoolYearDao;
import gov.ssa.entity.SchoolYear;

@Transactional
@Repository
public class SchoolYearDao implements ISchoolYearDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SchoolYear> getAllSchoolYears() {
		String hql = "from SchoolYear sy order by sy.id";		
		return (List<SchoolYear>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SchoolYear> getSemestersSince(int start_semester) {
		String hql = "from SchoolYear sy where sy.id >= :start_semester";
		return (List<SchoolYear>) hibernateTemplate.findByNamedParam(hql, "start_semester", start_semester);
	}

	@Override
	public SchoolYear getSchoolYearById(int id) {
		String hql = "from SchoolYear where id = :id";
		return (SchoolYear) hibernateTemplate.findByNamedParam(hql, "id", id).get(0);
	}

	@Override
	public void addSchoolYear(SchoolYear sy) {
		hibernateTemplate.save(new SchoolYear(sy.getSemester()));
	}

	@Override
	public void updateSchoolYear(SchoolYear sy) {
		System.err.println("UPDATE SchoolYear with id = " + sy.getId() + " and semester = " + sy.getSemester());
		
		hibernateTemplate.update(sy);		
	}

	@Override
	public void deleteSchoolYear(int id) {
		hibernateTemplate.delete(getSchoolYearById(id));
	}
}

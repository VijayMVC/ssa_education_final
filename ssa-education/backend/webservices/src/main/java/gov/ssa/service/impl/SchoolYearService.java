package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.ISchoolYearDao;
import gov.ssa.entity.SchoolYear;
import gov.ssa.service.iface.ISchoolYearService;

@Service
public class SchoolYearService implements ISchoolYearService {
	@Autowired
	private ISchoolYearDao syDao;	
	
	@Override
	public List<SchoolYear> getAllSchoolYears() {
		return syDao.getAllSchoolYears();
	}
	
	@Override
	public List<SchoolYear> getSemestersSince(int begin_semester) {
		return syDao.getSemestersSince(begin_semester);
	}

	@Override
	public SchoolYear getSchoolYearById(int id) {
		return syDao.getSchoolYearById(id);
	}

	@Override
	public void addSchoolYear(SchoolYear sy) {
		syDao.addSchoolYear(sy);
	}

	@Override
	public void updateSchoolYear(SchoolYear sy) {
		syDao.updateSchoolYear(sy);
	}

	@Override
	public void deleteSchoolYear(int id) {
		syDao.deleteSchoolYear(id);
	}

}

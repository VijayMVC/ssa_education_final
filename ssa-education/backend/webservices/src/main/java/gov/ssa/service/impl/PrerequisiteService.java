package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.IPrerequisiteDao;
import gov.ssa.entity.Prerequisite;
import gov.ssa.service.iface.IPrerequisiteService;

@Service
public class PrerequisiteService implements IPrerequisiteService {
	@Autowired
	private IPrerequisiteDao prereqDao;	
	
	@Override
	public List<Prerequisite> getAllPrerequisites() {
		return prereqDao.getAllPrerequisites();
	}
	
	@Override
	public List<Prerequisite> getPrerequisitesByClass(int id) {
		return prereqDao.getPrerequisitesByClass(id);
	}
	
	@Override
	public List<Prerequisite> getPrerequisitesForStudent(int studentId, int classId, int semester) {
		return prereqDao.getPrerequisitesForStudent(studentId, classId, semester);
	}
}

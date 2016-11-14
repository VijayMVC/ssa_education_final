package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IMajorDao;
import gov.ssa.entity.Major;
import gov.ssa.entity.Class;
import gov.ssa.service.iface.IMajorService;

@Service
@Transactional
public class MajorService implements IMajorService {
	@Autowired
	private IMajorDao majorDao;	
	
	@Override
	public List<Major> getAllMajors() {
		return majorDao.getAllMajors();
	}

	@Override
	public List<Class> getAllClassesForMajor(int id) {
		return majorDao.getAllClassesForMajor(id);
	}
	
	@Override
	public List<Class> getClassesRemainingForMajor(int studentId) {
		return majorDao.getClassesRemainingForMajor(studentId);
	}
	
	@Override
	public Major getMajorById(int majorId) {
		return majorDao.getMajorById(majorId);
	}
	
	@Override
	public void addMajor(Major major) {
		majorDao.addMajor(major);
	}

	@Override
	public void updateMajor(Major major) {
		majorDao.updateMajor(major);
	}

	@Override
	public void deleteMajor(int majorId) {
		majorDao.deleteMajor(majorId);
	}

}

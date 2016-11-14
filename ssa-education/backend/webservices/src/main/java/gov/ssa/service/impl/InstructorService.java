package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.IInstructorDao;
import gov.ssa.entity.Instructor;
import gov.ssa.service.iface.IInstructorService;

@Service
public class InstructorService implements IInstructorService {
	@Autowired
	private IInstructorDao instructorDao;
	
	@Override
	public List<Instructor> getAllInstructors() {
		return instructorDao.getAllInstructors();
	}

	@Override
	public Instructor getInstructorById(int id) {
		return instructorDao.getInstructorById(id);
	}

	@Override
	public void addInstructor(Instructor instructor) {
		instructorDao.addInstructor(instructor);
	}

	@Override
	public void updateInstructor(Instructor instructor) {
		instructorDao.updateInstructor(instructor);		
	}

	@Override
	public void deleteInstructor(int id) {
		instructorDao.deleteInstructor(id);		
	}
}

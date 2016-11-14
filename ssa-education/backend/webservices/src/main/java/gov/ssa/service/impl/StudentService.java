package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.IStudentDao;
import gov.ssa.entity.Student;
import gov.ssa.service.iface.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);		
	}

	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);		
	}
}

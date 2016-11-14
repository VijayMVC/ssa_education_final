package gov.ssa.service.iface;

import java.util.List;

import gov.ssa.entity.Student;

public interface IStudentService {
	List<Student> getAllStudents();
	
	Student getStudentById(int studentId);
	
	void addStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudent(int id);
}

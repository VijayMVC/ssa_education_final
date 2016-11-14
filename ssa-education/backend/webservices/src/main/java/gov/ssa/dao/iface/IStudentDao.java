package gov.ssa.dao.iface;

import java.util.List;

import gov.ssa.entity.Student;

public interface IStudentDao {
	List<Student> getAllStudents();
	
	Student getStudentById(int studentId);
	
	Student getStudentByAccount(int accountId);
	
	void addStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudent(int id);
}

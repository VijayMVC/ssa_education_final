package gov.ssa.service.iface;

import java.util.List;

import gov.ssa.entity.StudentClassesTaken;

public interface IAcademicService {
	List<StudentClassesTaken> getAllClassesTaken();
	
	List<StudentClassesTaken> getAllClassesForStudent(int student_id);
	
	List<StudentClassesTaken> getClassesForStudentForSemester(int semester_id, int student_id);
	
	List<StudentClassesTaken> prerequisitesMet(int studentId, int classId, int semester);
	
	List<StudentClassesTaken> getMajorClassesCompleted(int studentId);
	
	List<StudentClassesTaken> getElectiveClassesCompleted(int studentId);
	
	List<StudentClassesTaken> getMajorClassesInProgress(int studentId);
	
	List<StudentClassesTaken> getNumberStudentsEnrolled(int id);
	
	StudentClassesTaken getStudentClassesTakenById(int id);
	
	void addClassTaken(List<StudentClassesTaken> sct_list);
	
	void updateClassTaken(StudentClassesTaken sct);
	
	void deleteClassTaken(List<Integer> sct_id_list);
}

package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IAcademicDao;
import gov.ssa.entity.StudentClassesTaken;

@Transactional
@Repository
public class AcademicDao implements IAcademicDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> getAllClassesTaken() {
		String hql = "from StudentClassesTaken sct order by sct.id";
		return (List<StudentClassesTaken>) hibernateTemplate.find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> getAllClassesForStudent(int student_id) {
		String hql = "from StudentClassesTaken sct where sct.student_id.id = :student_id order by sct.id";
		return (List<StudentClassesTaken>) hibernateTemplate.findByNamedParam(hql, "student_id", student_id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> getClassesForStudentForSemester(int semester_id, int student_id) {
		String hql = "from StudentClassesTaken sct where sct.student_id.id = :student_id and " +
				"sct.class_list_id.semester.id = :semester_id order by sct.id";
		return (List<StudentClassesTaken>) hibernateTemplate.findByNamedParam(hql, 
				new String[] {"semester_id", "student_id"}, 
				new Object[] {semester_id, student_id});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> prerequisitesMet(int studentId, int classId, int semester) {
		String hql = "from Prerequisite p where p.class_id.id = :classId and " +
				"p.prereq_class_id.id not in (" +
				"select p.prereq_class_id.id from StudentClassesTaken sct where sct.student_id.id= :studentId" +
				" and sct.class_list_id.semester.semester.id < :semester and "
				+ "sct.class_list_id.class_id.id = p.prereq_class_id.id)))";
		
		return (List<StudentClassesTaken>) hibernateTemplate.findByNamedParam(hql,
				new String[] {"studentId", "classId", "semester"},
				new Object[] {studentId, classId, semester});						
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> getMajorClassesCompleted(int studentId) {
		String hql = "from StudentClassesTaken sct where sct.student_id.id= :studentId" +
				" and sct.grade is not null and sct.class_list_id.class_id.id in (" +
				"select mc.class_id.id from MajorClass mc where mc.major_id.id = (" +
				"select s.major_id.id from Student s where s.id= :studentId)" +
				")";
		return (List<StudentClassesTaken>) hibernateTemplate.findByNamedParam(hql, "studentId", studentId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> getElectiveClassesCompleted(int studentId) {
		String hql = "from StudentClassesTaken sct where sct.student_id.id= :studentId" +
				" and sct.grade is not null and sct.class_list_id.class_id.id not in (" +
				"select mc.class_id.id from MajorClass mc where mc.major_id.id = (" +
				"select s.major_id.id from Student s where s.id= :studentId)" +
				")";
		
		return (List<StudentClassesTaken>) hibernateTemplate.findByNamedParam(hql, "studentId", studentId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> getMajorClassesInProgress(int studentId) {
		String hql = "from StudentClassesTaken sct where sct.student_id.id= :studentId" +
				" and sct.grade is null and sct.class_list_id.class_id.id in (" +
				"select mc.class_id.id from MajorClass mc where mc.major_id.id = (" +
				"select s.major_id.id from Student s where s.id= :studentId)" +
				")";
		
		return (List<StudentClassesTaken>) hibernateTemplate.findByNamedParam(hql, "studentId", studentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentClassesTaken> getNumberStudentsEnrolled(int id) {
		String hql = "from StudentClassesTaken sct where sct.class_list_id.id = :id";
		return (List<StudentClassesTaken>) hibernateTemplate.findByNamedParam(hql, "id", id);
	}
	
	@Override
	public StudentClassesTaken getStudentClassesTakenById(int id) {
		String hql = "from StudentClassesTaken sct where sct.id = :id";
	
		return (StudentClassesTaken) hibernateTemplate.findByNamedParam(hql, "id", id).get(0);	
	}

	@Override
	public void addClassTaken(List<StudentClassesTaken> sct_list) {
		for(StudentClassesTaken sct : sct_list) {
			hibernateTemplate.save(sct);
		}
	}

	@Override
	public void updateClassTaken(StudentClassesTaken sct) {
		hibernateTemplate.update(sct);
	}

	@Override
	public void deleteClassTaken(List<Integer> sct_id_list) {
		for(int sct_id : sct_id_list) {
			hibernateTemplate.delete(getStudentClassesTakenById(sct_id));
		}
	}

}

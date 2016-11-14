package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IStudentDao;
import gov.ssa.entity.Student;

@Transactional
@Repository
public class StudentDao implements IStudentDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudents() {
        String hql = "FROM Student as s ORDER BY s.id";
        return (List<Student>) hibernateTemplate.find(hql);
    }
    
    @Override
	public Student getStudentById(int studentId) {
		String hql = "from Student as s where id = :studentId";

		return (Student) hibernateTemplate.findByNamedParam(hql, "studentId", studentId).get(0);		
	}
    
    @Override
    public Student getStudentByAccount(int accountId) {
    	String hql = "from Student as s where account_id.id = :accountId";
    	return (Student) hibernateTemplate.findByNamedParam(hql, "accountId", accountId).get(0);
    }

	@Override
	public void addStudent(Student student) {
		hibernateTemplate.save(new Student(
											student.getFirst_name(),
											student.getLast_name(),
											student.getGpa(),
											student.getFirst_semester(),
											student.getMajor_id(),
											student.getAccount_id()
				));
	}

	@Override
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}

	@Override
	public void deleteStudent(int id) {
		hibernateTemplate.delete(getStudentById(id));
	}
}

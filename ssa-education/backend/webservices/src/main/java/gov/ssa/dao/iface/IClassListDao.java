package gov.ssa.dao.iface;

import java.util.List;

import gov.ssa.entity.ClassList;

public interface IClassListDao {
	List<ClassList> getClassList();

	List<ClassList> getClassesBySemester(int semester);
	
	List<ClassList> getClassListByDepartment(int semester, int id);
	
	List<ClassList> getSectionsOfClass(int semester, int id);

	List<ClassList> getSectionsOfClass(int semester, int department, String num);
	
	ClassList getClassByCRN(String crns);
	
	ClassList getClassListById(int id);
	
	void addClassList(ClassList cl);
	
	void updateClassList(ClassList cl);
	
	void deleteClassList(int id);
}

package gov.ssa.dao.iface;

import java.util.List;

import gov.ssa.entity.Prerequisite;

public interface IPrerequisiteDao {
	List<Prerequisite> getAllPrerequisites();
	
	List<Prerequisite> getPrerequisitesByClass(int id);
	
	List<Prerequisite> getPrerequisitesForStudent(int studentId, int classId, int semester);
}

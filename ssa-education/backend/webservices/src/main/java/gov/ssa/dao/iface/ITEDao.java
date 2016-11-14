package gov.ssa.dao.iface;

import java.util.List;

import gov.ssa.entity.ClassList;

public interface ITEDao {
	List<ClassList> getAllTEs();
	
	ClassList getTEById(int id);
}

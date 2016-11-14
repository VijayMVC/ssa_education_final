package gov.ssa.service.iface;

import java.util.List;

import gov.ssa.entity.ClassList;

public interface ITEService {
	List<ClassList> getAllTEs();
	
	ClassList getTEById(int id);
}

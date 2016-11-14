package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.ITEDao;
import gov.ssa.entity.ClassList;
import gov.ssa.service.iface.ITEService;

@Service
public class TEService implements ITEService {

	@Autowired
	private ITEDao teDao;
	
	@Override
	public List<ClassList> getAllTEs() {
		return teDao.getAllTEs();
	}
	
	@Override
	public ClassList getTEById(int id) {
		return teDao.getTEById(id);
	}
}

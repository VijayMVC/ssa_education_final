package gov.ssa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.IClassListDao;
import gov.ssa.entity.ClassList;
import gov.ssa.service.iface.IClassListService;

@Service
public class ClassListService implements IClassListService {
	@Autowired
	private IClassListDao clDao;

	@Override
	public List<ClassList> getClassList() {
		return clDao.getClassList();
	}

	@Override
	public List<ClassList> getClassesBySemester(int semester) {
		return clDao.getClassesBySemester(semester);
	}
	
	@Override
	public List<ClassList> getClassListByDepartment(int semester, int id) {
		return clDao.getClassListByDepartment(semester, id);
	}

	@Override
	public List<ClassList> getSectionsOfClass(int semester, int id) {
		return clDao.getSectionsOfClass(semester, id);
	}
	
	@Override
	public List<ClassList> getSectionsOfClass(int semester, int department, String num) {
		return clDao.getSectionsOfClass(semester, department, num);
	}
	
	@Override
	public ClassList getClassByCRN(String crns) {
		return clDao.getClassByCRN(crns);
	}

	@Override
	public ClassList getClassListById(int id) {
		return clDao.getClassListById(id);
	}

	@Override
	public void addClassList(ClassList cl) {
		clDao.addClassList(cl);
	}

	@Override
	public void updateClassList(ClassList cl) {
		clDao.updateClassList(cl);
	}

	@Override
	public void deleteClassList(int id) {
		clDao.deleteClassList(id);
	}	
}

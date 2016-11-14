package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.ITEDao;
import gov.ssa.entity.ClassList;

@Transactional
@Repository
public class TEDao implements ITEDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassList> getAllTEs() {
		String hql = "from TestEntity as te order by te.id";
		return (List<ClassList>) hibernateTemplate.find(hql);
	}

	@Override
	public ClassList getTEById(int id) {
		String hql = "from TestEntity as te where te.id = " + id;
		return (ClassList) hibernateTemplate.find(hql).get(0);
	}

	
}

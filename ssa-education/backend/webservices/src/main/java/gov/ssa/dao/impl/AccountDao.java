package gov.ssa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.dao.iface.IAccountDao;
import gov.ssa.entity.Account;
import gov.ssa.entity.Student;

@Transactional
@Repository
public class AccountDao implements IAccountDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public Student validateLogin(Account account) {
		String user = account.getUsername();
		String pass = account.getPassword();
		
		String hql = "from Account a where a.username= :user and a.password= :pass";
		
		List<Account> accountResult  = (List<Account>) hibernateTemplate.findByNamedParam(hql, 
				new String[] {"user", "pass"}, new Object[] {user, pass} );
	
		Student student;
		
		if(accountResult.size() > 0) {
			account = accountResult.get(0);
		
			hql = "from Student s where s.account_id.id= :accountId";
			student = (Student) hibernateTemplate.findByNamedParam(hql, "accountId", account.getId()).get(0);
		} else {
			student = null;
		}
			
		return student;
	}
	
	@Override
	public void insertAccount(Account account) {
		hibernateTemplate.save(new Account(account.getUsername(), account.getPassword()));
	}

	@Override
	public void updateAccount(Account account) {		
		hibernateTemplate.update(account);		
	}
}

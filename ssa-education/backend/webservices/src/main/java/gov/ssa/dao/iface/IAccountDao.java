package gov.ssa.dao.iface;

import gov.ssa.entity.Account;
import gov.ssa.entity.Student;

public interface IAccountDao {
	Student validateLogin(Account account);
	
	void insertAccount(Account account);
	
	void updateAccount(Account account);
}

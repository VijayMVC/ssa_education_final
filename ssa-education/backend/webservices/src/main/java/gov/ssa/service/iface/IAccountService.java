package gov.ssa.service.iface;

import gov.ssa.entity.Account;
import gov.ssa.entity.Student;

public interface IAccountService {
	Student validateLogin(Account account);
	
	void insertAccount(Account account);
	
	void updateAccount(Account account);
}

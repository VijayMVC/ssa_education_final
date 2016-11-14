package gov.ssa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.iface.IAccountDao;
import gov.ssa.entity.Account;
import gov.ssa.entity.Student;
import gov.ssa.service.iface.IAccountService;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountDao accountDao;	
	
	@Override
	public Student validateLogin(Account account) {
		return accountDao.validateLogin(account);
	}

	@Override
	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}
}

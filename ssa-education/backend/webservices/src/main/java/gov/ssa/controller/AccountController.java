package gov.ssa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.ssa.entity.Account;
import gov.ssa.entity.Student;
import gov.ssa.service.iface.IAccountService;

@CrossOrigin
@Controller
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
		
	@RequestMapping(value="/accounts/login", method = RequestMethod.POST)
	public ResponseEntity<Student> validateLogin(@RequestBody Account account) {
		return new ResponseEntity<Student>(accountService.validateLogin(account), HttpStatus.OK);
	}
/*	
	@RequestMapping(value="/school_years/school_year", method = RequestMethod.POST)
	public ResponseEntity<Void> addSchoolYear(@RequestBody SchoolYear sy) {
		syService.addSchoolYear(sy);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/school_years/school_year", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateSchoolYear(@RequestBody SchoolYear sy) {
		syService.updateSchoolYear(sy);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/school_years/school_year/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteSchoolYear(@PathVariable("id") Integer id) {
		syService.deleteSchoolYear(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
*/	
}

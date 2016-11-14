package gov.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.ssa.entity.Department;
import gov.ssa.service.iface.IDepartmentService;

@CrossOrigin
@Controller
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;
	
	@RequestMapping(value= "/departments/department", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
    }
	
	@RequestMapping(value="/departments/department/{id}", method = RequestMethod.GET)
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Department>(departmentService.getDepartmentById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/departments/department", method = RequestMethod.POST)
	public ResponseEntity<Void> addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/departments/department", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateDepartment(@RequestBody Department department) {
		departmentService.updateDepartment(department);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/departments/department/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Integer id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
}

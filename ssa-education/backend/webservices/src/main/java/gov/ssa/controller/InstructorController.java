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

import gov.ssa.entity.Instructor;
import gov.ssa.service.iface.IInstructorService;

@CrossOrigin
@Controller
public class InstructorController {
	@Autowired
	private IInstructorService instructorService;
	
	@RequestMapping(value= "/instructors/instructor", method = RequestMethod.GET)
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return new ResponseEntity<List<Instructor>>(instructorService.getAllInstructors(), HttpStatus.OK);
    }
	
	@RequestMapping(value="/instructors/instructor/{id}", method = RequestMethod.GET)
	public ResponseEntity<Instructor> getInstructorById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Instructor>(instructorService.getInstructorById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/instructors/instructor", method = RequestMethod.POST)
	public ResponseEntity<Void> addInstructor(@RequestBody Instructor instructor) {
		instructorService.addInstructor(instructor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/instructors/instructor", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateInstructor(@RequestBody Instructor instructor) {
		instructorService.updateInstructor(instructor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/instructors/instructor/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteInstructor(@PathVariable("id") Integer id) {
		instructorService.deleteInstructor(id);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
}

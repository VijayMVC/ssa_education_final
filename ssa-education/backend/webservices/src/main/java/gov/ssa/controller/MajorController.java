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

import gov.ssa.entity.Class;
import gov.ssa.entity.Major;
import gov.ssa.service.iface.IMajorService;

@CrossOrigin
@Controller
public class MajorController {
	
	@Autowired
	private IMajorService majorService;
	
	@RequestMapping(value= "/majors/major", method = RequestMethod.GET)
    public ResponseEntity<List<Major>> getAllMajors() {
        return new ResponseEntity<List<Major>>(majorService.getAllMajors(), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/majors/list_major_classes/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClassesForMajor(@PathVariable("id") Integer id) {
        return new ResponseEntity<List<Class>>(majorService.getAllClassesForMajor(id), HttpStatus.OK);
    }
	
	@RequestMapping(value="/majors/list_major_classes_remaining/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<List<Class>> getClassesRemainingForMajor(
			@PathVariable("studentId") Integer studentId) {
		return new ResponseEntity<List<Class>>(majorService.getClassesRemainingForMajor(studentId),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/majors/major/{id}", method = RequestMethod.GET)
	public ResponseEntity<Major> getMajorById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Major>(majorService.getMajorById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/majors/major", method = RequestMethod.POST)
	public ResponseEntity<Void> addMajor(@RequestBody Major major) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/majors/major", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateMajor(@RequestBody Major major) {
		majorService.updateMajor(major);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/majors/major/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteMajor(@PathVariable("id") Integer id) {
		majorService.deleteMajor(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
}

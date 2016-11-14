package gov.ssa.controller;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.ssa.entity.Prerequisite;
import gov.ssa.service.iface.IPrerequisiteService;

@CrossOrigin
@Controller
public class PrerequisiteController {
	
	private static Properties props;
	static {
		props = new Properties();
		
		try {
			props.load(new FileInputStream("common/common.properties"));
		} catch(Exception ex) {
			ex.printStackTrace();
		} 
	}
	
	@Autowired
	private IPrerequisiteService prereqService;
	
	@RequestMapping(value= "/prereqs/prereq", method = RequestMethod.GET)
    public ResponseEntity<List<Prerequisite>> getAllPrerequisites() {
        return new ResponseEntity<List<Prerequisite>>(prereqService.getAllPrerequisites(), HttpStatus.OK);
    }
	
	@RequestMapping(value="/prereqs/prereq/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Prerequisite>> getPrerequisitesByClass(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<Prerequisite>>(prereqService.getPrerequisitesByClass(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/prereqs/student_satisfied/{studentId}/{classId}", method = RequestMethod.GET)
	public ResponseEntity<List<Prerequisite>> getPrerequisitesForStudent(@PathVariable("studentId") Integer studentId,
																		 @PathVariable("classId") Integer classId) {
		return new ResponseEntity<List<Prerequisite>>(prereqService.getPrerequisitesForStudent(studentId, classId,
				Integer.parseInt(props.getProperty("current.year"))), HttpStatus.OK);
				
	}
}

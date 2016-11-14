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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.ssa.entity.StudentClassesTaken;
import gov.ssa.service.iface.IAcademicService;

@CrossOrigin
@Controller
public class AcademicController {

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
	private IAcademicService acService;
	
	@RequestMapping(value= "/academics", method = RequestMethod.GET)
    public ResponseEntity<List<StudentClassesTaken>> getAllClassesTaken() {
        return new ResponseEntity<List<StudentClassesTaken>>(acService.getAllClassesTaken(), HttpStatus.OK);
    }
	
	@RequestMapping(value="/academics/student/{student_id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentClassesTaken>> getAllClassesForStudent(@PathVariable("student_id") Integer student_id) {
		return new ResponseEntity<List<StudentClassesTaken>>(acService.getAllClassesForStudent(student_id), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/academics/student_semester/{student_id}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentClassesTaken>> getClassesForStudentForSemesterCurrent(
    		@PathVariable("student_id") Integer student_id) {
        return new ResponseEntity<List<StudentClassesTaken>>(
        		acService.getClassesForStudentForSemester(
        				Integer.parseInt(props.getProperty("current.year")), student_id), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/academics/student_semester/{semester}/{student_id}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentClassesTaken>> getClassesForStudentForSemester(
    		@PathVariable("semester") Integer semester,
    		@PathVariable("student_id") Integer student_id) {
        return new ResponseEntity<List<StudentClassesTaken>>(
        		acService.getClassesForStudentForSemester(semester, student_id), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/academics/prerequisites_met/{studentId}/{classId}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentClassesTaken>> prerequisitesMet(@PathVariable("studentId") Integer studentId, 
																	  @PathVariable("classId") Integer classId) {
		return new ResponseEntity<List<StudentClassesTaken>>(
				acService.prerequisitesMet(studentId, classId, 
						Integer.parseInt(props.getProperty("current.year"))), HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics/student_major_classes_completed/{studentId}")
	public ResponseEntity<List<StudentClassesTaken>> getMajorClassesCompleted(
			@PathVariable("studentId") Integer studentId) {
		return new ResponseEntity<List<StudentClassesTaken>>(
				acService.getMajorClassesCompleted(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics/student_elective_classes_completed/{studentId}")
	public ResponseEntity<List<StudentClassesTaken>> getElectiveClassesCompleted(
			@PathVariable("studentId") Integer studentId) {
		return new ResponseEntity<List<StudentClassesTaken>>(
				acService.getElectiveClassesCompleted(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics/student_major_classes_in_progress/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentClassesTaken>> getMajorClassesInProgress(
			@PathVariable("studentId") Integer studentId) {
		return new ResponseEntity<List<StudentClassesTaken>>(
				acService.getMajorClassesInProgress(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics/number_enrolled/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentClassesTaken>> getNumberStudentsEnrolled(@PathVariable("id") Integer id) {		
		return new ResponseEntity<List<StudentClassesTaken>>(
				acService.getNumberStudentsEnrolled(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentClassesTaken> getStudentClassesTakenById(@PathVariable("id") Integer id) {
		return new ResponseEntity<StudentClassesTaken>(acService.getStudentClassesTakenById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics", method = RequestMethod.POST)
	public ResponseEntity<Void> addClassTaken(@RequestBody List<StudentClassesTaken> sct) {
		acService.addClassTaken(sct);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateClassTaken(@RequestBody StudentClassesTaken sct) {
		acService.updateClassTaken(sct);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/academics/{sct_id_list}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteClassList(@PathVariable("sct_id_list") List<Integer> sct_id_list) {
		acService.deleteClassTaken(sct_id_list);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
}

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

import gov.ssa.entity.SchoolYear;
import gov.ssa.service.iface.ISchoolYearService;

@CrossOrigin
@Controller
public class SchoolYearController {
	
	@Autowired
	private ISchoolYearService syService;
	
	@RequestMapping(value= "/school_years/school_year", method = RequestMethod.GET)
    public ResponseEntity<List<SchoolYear>> getAllSchoolYears() {
        return new ResponseEntity<List<SchoolYear>>(syService.getAllSchoolYears(), HttpStatus.OK);
    }
	
	@RequestMapping(value="/school_years/semesters_since/{begin_semester}", method = RequestMethod.GET)
	public ResponseEntity<List<SchoolYear>> getSemestersSince(@PathVariable("begin_semester") Integer begin_semester) {
		return new ResponseEntity<List<SchoolYear>>(syService.getSemestersSince(begin_semester), HttpStatus.OK);
	}
	
	@RequestMapping(value="/school_years/school_year/{id}", method = RequestMethod.GET)
	public ResponseEntity<SchoolYear> getSchoolYearById(@PathVariable("id") Integer id) {
		return new ResponseEntity<SchoolYear>(syService.getSchoolYearById(id), HttpStatus.OK);
	}
	
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
	
}

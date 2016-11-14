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

import gov.ssa.entity.ClassList;
import gov.ssa.service.iface.IClassListService;

@CrossOrigin
@Controller
public class ClassListController {
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
	private IClassListService clService;
		
	@RequestMapping(value= "/class_list", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getClassList() {		
        return new ResponseEntity<List<ClassList>>(clService.getClassesBySemester(
        		Integer.parseInt(props.getProperty("current.year"))), HttpStatus.OK);
    }
	
	@RequestMapping(value="/class_list/list_by_semester/{semester}", method = RequestMethod.GET)
	public ResponseEntity<List<ClassList>> getClassesBySemester(@PathVariable("semester") Integer semester) {
		return new ResponseEntity<List<ClassList>>(clService.getClassesBySemester(semester), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/class_list/list_by_department/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getClassesByDepartmentCurrent(@PathVariable("id") Integer id) {
        return new ResponseEntity<List<ClassList>>(clService.
        		getClassListByDepartment(Integer.parseInt(props.getProperty("current.year")), id), HttpStatus.OK);
    }
		
	@RequestMapping(value= "/class_list/list_by_department/{semester}/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getClassListByDepartment(@PathVariable("semester") Integer semester,
    		                                                        @PathVariable("id") Integer id) {
        return new ResponseEntity<List<ClassList>>(clService.getClassListByDepartment(semester, id), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/class_list/sections_by_class_id/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getSectionsOfClassCurrent(@PathVariable("id") Integer id) {
        return new ResponseEntity<List<ClassList>>(clService.getSectionsOfClass(
        		Integer.parseInt(props.getProperty("current.year")), id), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/class_list/sections_by_class_id/{semester}/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getSectionsOfClass(@PathVariable("semester") Integer semester,
    														  @PathVariable("id") Integer id) {
        return new ResponseEntity<List<ClassList>>(clService.getSectionsOfClass(semester, id), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/class_list/sections_by_class/{department}/{num}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getSectionsOfClassCurrent(@PathVariable("department") Integer department,
    														         @PathVariable("num") String num) {
        return new ResponseEntity<List<ClassList>>(clService.getSectionsOfClass(
        		Integer.parseInt(props.getProperty("current.year")), department, num), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/class_list/sections_by_class/{semester}/{department}/{num}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getSectionsOfClass(@PathVariable("semester") Integer semester,
    														  @PathVariable("department") Integer department,
    														  @PathVariable("num") String num) {
        return new ResponseEntity<List<ClassList>>(clService.getSectionsOfClass(semester, department, num), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/class_list/class_by_crn/{crns}", method = RequestMethod.GET)
	public ResponseEntity<ClassList> getClassByCRN(@PathVariable("crns") String crns) {
		return new ResponseEntity<ClassList> (clService.getClassByCRN(crns), HttpStatus.OK);
	}
	
	@RequestMapping(value="/class_list/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClassList> getClassListById(@PathVariable("id") Integer id) {
		return new ResponseEntity<ClassList>(clService.getClassListById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/class_list", method = RequestMethod.POST)
	public ResponseEntity<Void> addClassList(@RequestBody ClassList cl) {
		clService.addClassList(cl);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/class_list", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateClassList(@RequestBody ClassList cl) {
		clService.updateClassList(cl);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/class_list/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteClassList(@PathVariable("id") Integer id) {
		clService.deleteClassList(id);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
}

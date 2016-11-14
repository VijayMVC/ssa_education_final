package gov.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.ssa.entity.ClassList;
import gov.ssa.service.iface.ITEService;

@CrossOrigin
@Controller
public class TEController {
	@Autowired
	private ITEService teService;
	
	@RequestMapping(value= "/TEs/TE", method = RequestMethod.GET)
    public ResponseEntity<List<ClassList>> getAllTEs() {
        return new ResponseEntity<List<ClassList>>(teService.getAllTEs(), HttpStatus.OK);
    }
	
	@RequestMapping(value="/TEs/TE/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClassList> getTEById(@PathVariable("id") Integer id) {
		return new ResponseEntity<ClassList>(teService.getTEById(id), HttpStatus.OK);
	}
}

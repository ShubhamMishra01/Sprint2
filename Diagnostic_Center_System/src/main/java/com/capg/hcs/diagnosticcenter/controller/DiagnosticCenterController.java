package com.capg.hcs.diagnosticcenter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcs.diagnosticcenter.model.DiagnosticCenter;
import com.capg.hcs.diagnosticcenter.model.DiagnosticCenterList;
import com.capg.hcs.diagnosticcenter.service.IDiagnosticCenterService;

@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {

	@Autowired
	private IDiagnosticCenterService centerService;
	/**
	 * Name___________:addCenter
	 * Description____:To add a new center in the database
	 * Parameter(s)___:DiagnosticCenter
	 * Returns________:center
	 * Last Modified__:08/05/2020
	 */
	@PostMapping("/addcenter")
	public ResponseEntity<DiagnosticCenter> addCenter(@RequestBody DiagnosticCenter center)
	{
		return new ResponseEntity<DiagnosticCenter>(centerService.addCenter(center),HttpStatus.CREATED); 
	}
	/**
	 * Name___________:removeCenter
	 * Description____:To remove a new center in the database
	 * Parameter(s)___:DiagnosticCenter
	 * Returns________:messege
	 * Last Modified__:08/05/2020
	 */

	@DeleteMapping("/removecenter/center-id/{centerId}")
	public String removeCenter(@PathVariable String centerId)
	{
		ResponseEntity<DiagnosticCenter> center=getCenter(centerId);
		if(centerService.removeCenter(center.getBody()));
		     return "Center Deleted Successfully";
	}
	/**
	 * Name___________:getCenterId
	 * Description____:To get details of center by searching center id.
	 * Parameter(s)___:String
	 * Returns________:String
	 * Last Modified__:08/05/2020
	 */

	@GetMapping("/getcenter/center-id/{centerId}")
	public ResponseEntity<DiagnosticCenter> getCenter(@PathVariable String centerId)
	{
		return new ResponseEntity<DiagnosticCenter>(centerService.getCenterById(centerId),HttpStatus.FOUND);
	}
	
	/**
	 * Name___________:getAllCenters
	 * Description____:To show all the added centers in the database
	 * Returns________:List of centers
	 * Last Modified__:08/05/2020
	 */
	
	@GetMapping("/getallcenters")
	public ResponseEntity<DiagnosticCenterList> getAllCenters()
	{
		DiagnosticCenterList centerList=centerService.getAllCenters();
		if(centerList==null)
	    	return new ResponseEntity<DiagnosticCenterList>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<DiagnosticCenterList>(centerList,HttpStatus.OK);
			
	}
	/**
	 * Name___________:removeAllCenters
	 * Description____:To remove all the added centers from the database
	 * Returns________:messege
	 * Last Modified__:08/05/2020
	 */

	@DeleteMapping("removeallcenters")
	public String removeAllCenters() 
	{
		centerService.removeAllCenters();
			return "All Center Removed";
	}	
}

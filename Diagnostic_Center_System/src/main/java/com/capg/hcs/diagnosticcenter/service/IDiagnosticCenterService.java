package com.capg.hcs.diagnosticcenter.service;

import com.capg.hcs.diagnosticcenter.model.DiagnosticCenter;
import com.capg.hcs.diagnosticcenter.model.DiagnosticCenterList;


public interface IDiagnosticCenterService {

	DiagnosticCenterList getAllCenters();

	DiagnosticCenter addCenter(DiagnosticCenter center);
	
	DiagnosticCenter getCenterById(String centerId);
    
	boolean removeAllCenters();
	
	boolean removeCenter(DiagnosticCenter center);
}


























//DiagnosticCenter assignTestId(String centerId,String testId);

	//DiagnosticCenter assignAppointmentId(String centerId,BigInteger appointmentId);
	
	//boolean removeTestId(String centerId,String testId);
package com.capg.hcs.diagnosticcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcs.diagnosticcenter.model.DiagnosticCenter;



public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, String>{
	
	public DiagnosticCenter getByCenterName(String centerName);

}

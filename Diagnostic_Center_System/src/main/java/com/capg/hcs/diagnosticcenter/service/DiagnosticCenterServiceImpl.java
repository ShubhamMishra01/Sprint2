package com.capg.hcs.diagnosticcenter.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcs.diagnosticcenter.exception.CenterListIsEmptyException;
import com.capg.hcs.diagnosticcenter.exception.CenterNameAlreadyExistException;
import com.capg.hcs.diagnosticcenter.exception.CenterNotFoundException;
import com.capg.hcs.diagnosticcenter.model.DiagnosticCenter;
import com.capg.hcs.diagnosticcenter.model.DiagnosticCenterList;
import com.capg.hcs.diagnosticcenter.repository.IDiagnosticCenterRepository;


@Service
public class DiagnosticCenterServiceImpl implements IDiagnosticCenterService {

    @Autowired
	private IDiagnosticCenterRepository centerRepo;
	@Autowired
    private Random random;
	final int RANGE=10000000;
	/**
	 * Name___________:addCenter
	 * Description____:To add a new center in the database
	 * Parameter(s)___:DiagnosticCenter
	 * Returns________:center
	 * Last Modified__:07/05/2020
	 */
	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center){
		center.setCenterId(Integer.toString(random.nextInt(RANGE)).substring(0,5));
		if(centerRepo.getByCenterName(center.getCenterName())!=null) {
			throw new CenterNameAlreadyExistException("Center with Name :" + center.getCenterName()+" is Already Exist");
		}
		return centerRepo.save(center);
	}
	/**
	 * Name___________:removeCenter
	 * Description____:To remove a new center in the database
	 * Parameter(s)___:DiagnosticCenter
	 * Returns________: messege
	 * Last Modified__:07/05/2020
	 */

	@Override
	public boolean removeCenter(DiagnosticCenter center) {
		if(!centerRepo.existsById(center.getCenterId()))
 			throw new CenterNotFoundException("Center with Id :" + center.getCenterId()+" is Not Found");
		centerRepo.delete(center);
		return !centerRepo.existsById(center.getCenterId());
	}
	/**
	 * Name___________:getCenterId
	 * Description____:To get details of center by searching center id.
	 * Parameter(s)___:String
	 * Returns________:String
	 * Last Modified__:07/05/2020
	 */
	@Override
	public DiagnosticCenter getCenterById(String centerId) {
		if(!centerRepo.existsById(centerId))
 			throw new CenterNotFoundException("Center with Id :" + centerId+" is Not Found");
		return centerRepo.getOne(centerId);
	}
	/**
	 * Name___________:getAllCenters
	 * Description____:To show all the added centers in the database
	 * Returns________:List of centers
	 * Last Modified__:07/05/2020
	 */
	@Override
	public DiagnosticCenterList getAllCenters() {
		if(centerRepo.findAll().isEmpty()) {
			throw new CenterListIsEmptyException("CenterList Is Empty");
		}
		return new DiagnosticCenterList(centerRepo.findAll());
	}
	/**
	 * Name___________:removeAllCenters
	 * Description____:To remove all the added centers from the database
	 * Returns________:messege
	 * Last Modified__:07/05/2020
	 */

	@Override
	public boolean removeAllCenters() {
		centerRepo.deleteAll();		
		return true;
	}
	
}

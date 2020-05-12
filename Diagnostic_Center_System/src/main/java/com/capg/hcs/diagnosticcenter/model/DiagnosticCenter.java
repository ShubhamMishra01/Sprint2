package com.capg.hcs.diagnosticcenter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "center_info")
public class DiagnosticCenter {
	@Id
	private String centerId;	
	private String centerName;
	private String contactNo;
	private String centerAddress;
	
	public DiagnosticCenter(){
		super();
	}
	public DiagnosticCenter( String centerName,String contactNo,String centerAddress) {
		super();
		this.centerName = centerName;
		this.contactNo = contactNo;
		this.centerAddress = centerAddress;
	}
	public DiagnosticCenter(String centerId, String centerName,String contactNo,String centerAddress) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.contactNo = contactNo;
		this.centerAddress = centerAddress;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	
	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", centerContactNo=" + contactNo +", centerAddress=" + centerAddress + "]";
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

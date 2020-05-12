package com.capg.hcs.diagnosticcenter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcs.diagnosticcenter.exception.CenterListIsEmptyException;
import com.capg.hcs.diagnosticcenter.exception.CenterNameAlreadyExistException;
import com.capg.hcs.diagnosticcenter.exception.CenterNotFoundException;

@RestController
@ControllerAdvice
public class DiagnosticCenterErrorHandler {

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Center Name Already Exist")
	@ExceptionHandler(CenterNameAlreadyExistException.class)
	public void handleCenterNameAlreadyExistException()
	{
	       //To Handle CenterName Already Exist Exception	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Center Not Found ")
	@ExceptionHandler(CenterNotFoundException.class)
	public void handleCenterNotFoundException()
	{
	       //To Handle Center Not Found Exception	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "CenterList is Empty ")
	@ExceptionHandler(CenterListIsEmptyException.class)
	public void handleCenterListIsEmptyException()
	{
	       //To Handle CenterList is Empty Exception	
	}
}

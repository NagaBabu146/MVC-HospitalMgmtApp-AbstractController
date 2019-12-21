package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.PatientDetailsInfoCommand;
import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsResultDTO;
import com.nt.service.PatientMgmtService;

public class PatientInfoSearchController  extends AbstractCommandController{
	private PatientMgmtService service;
	
	public PatientInfoSearchController(PatientMgmtService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		PatientDetailsInfoCommand cmd=null;
		PatientDetailsInputDTO idto=null;
		
		List<PatientDetailsResultDTO> listRDTO=null;
		//type casting
		cmd=(PatientDetailsInfoCommand)command;
		//convert command to dto
		idto.setPatientName(cmd.getPatientName());
		idto.setProblem(cmd.getProblem());
		idto.setAdress(cmd.getAdress());
		idto.setDoctor(cmd.getDoctor());
		//use service
	    listRDTO=service.search(idto);
		ModelAndView mav=new ModelAndView("search_jobs","listRDTO" ,listRDTO);
		return mav;
	}

	
}

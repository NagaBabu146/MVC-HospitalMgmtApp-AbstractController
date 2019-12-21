package com.nt.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsResultBO;
import com.nt.dao.PatientSearchDAO;
import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsResultDTO;

public class PatientMgmtServiceImpl implements PatientMgmtService {
	private PatientSearchDAO dao;

	public PatientMgmtServiceImpl(PatientSearchDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<PatientDetailsResultDTO> search(PatientDetailsInputDTO idto) {
		
		PatientDetailsInputBO iBO=null;
		
	   List <PatientDetailsResultBO> listRBO=null;
	   List <PatientDetailsResultDTO> listRDTO=new ArrayList();
	   //convert iDTO to iBO
	   iBO=new PatientDetailsInputBO();
	   BeanUtils.copyProperties(idto, iBO);
	   if(iBO.getPatientName().length()!=0)
		   iBO.setPatientName(iBO.getPatientName()+"%");
	   if(iBO.getAdress().length()!=0)
		   iBO.setAdress(iBO.getAdress()+"%");
	   if(iBO.getProblem().length()!=0)
		  iBO.setProblem(iBO.getProblem()+"%");
	   if(iBO.getDoctor().length()!=0)
		   iBO.setDoctor(iBO.getDoctor()+"%");
	   //use dao
	   listRBO = dao.find(iBO);
	   //convert listRBO to listDTO
	   listRBO.forEach(bo->{
		   PatientDetailsResultDTO dto=new PatientDetailsResultDTO();
		   BeanUtils.copyProperties(bo, dto);
		 listRDTO.add(dto);
	   });
		return listRDTO;
	}

}

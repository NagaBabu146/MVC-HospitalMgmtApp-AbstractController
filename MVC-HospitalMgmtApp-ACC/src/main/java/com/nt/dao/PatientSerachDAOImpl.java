package com.nt.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsResultBO;

public class PatientSerachDAOImpl implements PatientSearchDAO {

	private static final String SEARCH_PATIENT_QUERY = "SELECT PATIENTID,PATIENTNAME,AGE,ADRESS,PROBLEM,WARDNO,DOCTOR,CONTACT FROM PATIENT_INFO "
			+ " WHERE  (PATIENTNAME IS NOT NULL AND PATIENTNAME LIKE ? )" + " OR (ADRESS IS NOT NULL AND ADRESS LIKE ?)"
			+ " OR(PROBLEM IS NOT NULL AND PROBLEM LIKE ?)" + "OR(DOCTOR IS NOT NULL AND DOCTOR LIKE ? )";
	private JdbcTemplate jt;

	public PatientSerachDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<PatientDetailsResultBO> find(PatientDetailsInputBO ibo) {
		List<PatientDetailsResultBO> listRBO=null;
		//use jt
		listRBO=(List<PatientDetailsResultBO>) jt.query(SEARCH_PATIENT_QUERY,new RowMapperResultSetExtractor(
				            		   new BeanPropertyRowMapper<PatientDetailsResultBO>(PatientDetailsResultBO.class))
				               ibo.getPatientName(),
				               ibo.getAdress(),
				               ibo.getDoctor(),
				               ibo.getProblem()
				               );
		return listRBO;
	}

}

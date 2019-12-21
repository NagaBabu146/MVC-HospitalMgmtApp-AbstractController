package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDetailsInputDTO implements Serializable {
	private String patientName;
	private String adress;
	private String problem;
	private String doctor;

}

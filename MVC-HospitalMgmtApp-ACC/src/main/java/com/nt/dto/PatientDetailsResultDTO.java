package com.nt.dto;

import lombok.Data;

@Data
public class PatientDetailsResultDTO extends PatientDetailsInputDTO{
	private int patientId;
	private int age;
	private String contact;
	private int wardNo;
}

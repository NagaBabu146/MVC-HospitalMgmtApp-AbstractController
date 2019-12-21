package com.nt.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class PatientDetailsResultBO extends PatientDetailsInputBO {
	private int patientId;
	private int age;
	private String contact;
	private int wardNo;
}

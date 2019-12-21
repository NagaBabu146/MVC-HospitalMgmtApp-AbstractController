package com.nt.command;

import lombok.Data;

@Data
public class PatientDetailsInfoCommand {

	private String patientName;
	private String adress;
	private String problem;
	private String doctor;
}

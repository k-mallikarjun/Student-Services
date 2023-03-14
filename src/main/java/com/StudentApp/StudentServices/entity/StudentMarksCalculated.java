package com.StudentApp.StudentServices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentMarksCalculated {

	private String name;
	private int standard;
	private int TotalNumberOfSubjects;
	private int NumberOfSubjectsPassed;
	private int NumberOfSubjectsFailed;
	private int NumberOfSubjectsNotAttended;
	private float TotalMarks;
	private float percentage;
	private String grade;
}

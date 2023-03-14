package com.StudentApp.StudentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentApp.StudentServices.entity.StudentMarksCalculated;
import com.StudentApp.StudentServices.entity.StudentMarksDetails;
import com.StudentApp.StudentServices.exception.DataNotFoundException;
import com.StudentApp.StudentServices.service.StudentMarksDetailsService;

@RestController
@RequestMapping("/StudentMarksDetails")
public class StudentMarksController {

	@Autowired
	StudentMarksDetailsService studentMarksDetailsService;
	
	@GetMapping("/MarksDetails/{id}")
	public List<StudentMarksDetails> marks(@PathVariable long id) {
		return studentMarksDetailsService.getmarksDetailsResp(id);
	}
	
	@GetMapping("/CalculateMarks/{id}")
	public StudentMarksCalculated  CalculatedMarks(@PathVariable long id)
	{
		return studentMarksDetailsService.getCalculatedMarks(id);
	}
	
	/*@PatchMapping("/MarksUpdateByid/{id}")
	public List<StudentMarksDetails> editStudentMarksDetails(@PathVariable long id, @RequestBody List<StudentMarksDetails> studentMarksDetails ) throws DataNotFoundException
	{
		
		return studentMarksDetailsService.EditStudentMarksDetails(id,studentMarksDetails);
		
	}*/
}

package com.StudentApp.StudentServices.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentApp.StudentServices.dto.BasicDetails;
import com.StudentApp.StudentServices.entity.StudentBasicDetails;
import com.StudentApp.StudentServices.exception.DataNotFoundException;
import com.StudentApp.StudentServices.service.StudentBasicDetailsService;

@RestController
@RequestMapping("/StudentBasicDetails")
public class StudentDetailsController {
	

	@Autowired
	StudentBasicDetailsService studentBasicDetailsService;

	@GetMapping("")
	public List<BasicDetails> StudentDetails() {
		return studentBasicDetailsService.getBasicStudentDetails();
		
	}
	
	@GetMapping("/{id}")
	public Optional<StudentBasicDetails> StudentDetailsByID(@PathVariable int id) {
		Optional<StudentBasicDetails> str=studentBasicDetailsService.getStudentDetailsById(id);
		return studentBasicDetailsService.getStudentDetailsById(id);
		
	}

	@PostMapping("/Add")
	public  StudentBasicDetails AddBasicDetails(@RequestBody StudentBasicDetails studentBasicDetails) {
		return studentBasicDetailsService.addStudentBasicDetails(studentBasicDetails);
	}
	
	@PatchMapping("/BasicUpdateByid/{id}")
	public StudentBasicDetails editStudentBasicDetails(@PathVariable long id, @RequestBody Map<String, Object> fields) throws DataNotFoundException
	{
		
		return studentBasicDetailsService.EditStudentBasicDetails(id,fields);
		
	}
	
	@DeleteMapping("/DeleteByid/{id}")
	public void DeleteStudentById(@PathVariable long id) throws DataNotFoundException{
		
		studentBasicDetailsService.DeleteStudentById(id);
		
	}
	
	
}

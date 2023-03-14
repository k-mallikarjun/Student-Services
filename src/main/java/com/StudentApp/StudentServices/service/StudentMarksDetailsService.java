package com.StudentApp.StudentServices.service;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;

import com.StudentApp.StudentServices.entity.StudentBasicDetails;
import com.StudentApp.StudentServices.entity.StudentMarksCalculated;
import com.StudentApp.StudentServices.entity.StudentMarksDetails;
import com.StudentApp.StudentServices.exception.DataNotFoundException;
import com.StudentApp.StudentServices.repository.StudentDetailsRespo;
import com.StudentApp.StudentServices.repository.StudentMarksRespo;

@Component
public class StudentMarksDetailsService {
	
	@Autowired
	StudentDetailsRespo studentDetailsresp;

	@Autowired
	StudentMarksRespo studentMarksRespo;
	
	
	
	public List<StudentMarksDetails> EditStudentMarksDetails(long id, List<StudentMarksDetails> studentMarksDetails) throws DataNotFoundException {
		// TODO Auto-generated method stub
		List<StudentMarksDetails> stdOptional=studentDetailsresp.getMarksDetailsResp(id);
		if(stdOptional != null)
		{
			for(int i=0;i<stdOptional.size();i++)
			{
				Field field = ReflectionUtils.findRequiredField(StudentMarksDetails.class, "subject");
				field.setAccessible(true);
	            ReflectionUtils.setField(field, stdOptional.get(i), studentMarksDetails.get(i).getSubject());
	            Field field2 = ReflectionUtils.findRequiredField(StudentMarksDetails.class, "marks");
				field2.setAccessible(true);
	            ReflectionUtils.setField(field2, stdOptional.get(i), studentMarksDetails.get(i).getMarks());
	            studentMarksRespo.save(stdOptional.get(i));
			}
			return studentDetailsresp.getMarksDetailsResp(id);
		}
		else {
			throw new DataNotFoundException("ID doesn't exists");
		}
		
	}


	public List<StudentMarksDetails> getmarksDetailsResp(long id) {
		// TODO Auto-generated method stub
		return studentDetailsresp.getMarksDetailsResp(id);
	}
	
	
	public StudentMarksCalculated getCalculatedMarks(long id) {
		
		List<StudentMarksDetails> studentMarksDetails=studentDetailsresp.getMarksDetailsResp(id);
		Optional<StudentBasicDetails> basicDetails=studentDetailsresp.findById(id);
		String name=basicDetails.get().getName();
		int stand=basicDetails.get().getStandard();
		int totalSubjects=6; //default 6 subjects
		
		
		Map<String,Float> hm= new HashMap<>();
		float totalmarks=0;
		int totalPassed=0;
		int totalFailed=0;
		for(int i=0;i<studentMarksDetails.size();i++)
		{
			float temp=studentMarksDetails.get(i).getMarks();
			hm.put(studentMarksDetails.get(i).getSubject(),temp);
			totalmarks=totalmarks+temp;
			if(temp >= 35)
			{
				totalPassed++;
			}
			else {
				totalFailed++;
			}
			
		}
	
		int NotAttended=totalSubjects-(totalPassed+totalFailed);
		float percentage=(totalmarks/6);
		String grade="";
		if(percentage <= 35 )
		{
		  grade="FAIL";
		}
		else if(percentage >= 35 && percentage <= 50)
		{
			grade="PASS";
		}
		else if(percentage >= 50 && percentage <= 75)
		{
			grade="SECOND CLASS";
		}
		else if(percentage >= 75 )
		{
			grade="FIRST CLASS";
		}

		return new StudentMarksCalculated(name,stand,totalSubjects,totalPassed,totalFailed,NotAttended,totalmarks,percentage,grade);
	}
	
}

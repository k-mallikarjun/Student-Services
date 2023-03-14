package com.StudentApp.StudentServices.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;

import com.StudentApp.StudentServices.dto.BasicDetails;
import com.StudentApp.StudentServices.entity.StudentBasicDetails;
import com.StudentApp.StudentServices.exception.DataNotFoundException;
import com.StudentApp.StudentServices.repository.StudentDetailsRespo;
import com.StudentApp.StudentServices.repository.StudentMarksRespo;

@Component
public class StudentBasicDetailsService {
	
	@Autowired
	StudentDetailsRespo studentDetailsresp;
	
	@Autowired
	StudentMarksRespo studentMarksRespo;
	
	public List<BasicDetails> getBasicStudentDetails() {
		// TODO Auto-generated method stub
		return studentDetailsresp.getBasicDetails();
	}
	
	public Optional<StudentBasicDetails> getStudentDetailsById(long id) {
		return  studentDetailsresp.findById(id);
	}

	public StudentBasicDetails addStudentBasicDetails(StudentBasicDetails studentBasicDetails) {
		// TODO Auto-generated method stub
		return studentDetailsresp.save(studentBasicDetails);	
	    
	}


	public StudentBasicDetails EditStudentBasicDetails(long id, Map<String, Object> fields) throws DataNotFoundException {
		// TODO Auto-generated method stub
		Optional<StudentBasicDetails> stdOptional=studentDetailsresp.findById(id);
	
		//logics
		if(stdOptional.isPresent())
		{
			
			
			fields.forEach((key, value) -> {
				
                Field field = ReflectionUtils.findRequiredField(StudentBasicDetails.class, key);
                if(field.toString().equalsIgnoreCase("studentMarksDetails"))
                {
                	
                }
                else {
                	field.setAccessible(true);
                    ReflectionUtils.setField(field, stdOptional.get(), value);
                }
                
            });
            return studentDetailsresp.save(stdOptional.get());
		
		}
		else {
			throw new DataNotFoundException("ID doesn't exists");
		}

	}


	public void DeleteStudentById(Long id) throws DataNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<StudentBasicDetails> stdOptional=studentDetailsresp.findById(id);
		
		if(stdOptional.isPresent())
		{
			studentDetailsresp.deleteById(id);
		}
		else {
			throw new DataNotFoundException("ID doesn't exists");
		}

	
	}


}

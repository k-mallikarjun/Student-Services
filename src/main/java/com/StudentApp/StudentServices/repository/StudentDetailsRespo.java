package com.StudentApp.StudentServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.StudentApp.StudentServices.dto.BasicDetails;
import com.StudentApp.StudentServices.entity.StudentBasicDetails;
import com.StudentApp.StudentServices.entity.StudentMarksDetails;


public interface StudentDetailsRespo extends JpaRepository<StudentBasicDetails,Long>{

	@Query("SELECT new com.StudentApp.StudentServices.dto.BasicDetails(studentid, name, sex, standard) FROM StudentBasicDetails")
	public List<BasicDetails> getBasicDetails() ;
	
	@Query( "SELECT sb.studentMarksDetails FROM StudentBasicDetails sb where sb.studentid=:id")
	public List<StudentMarksDetails> getMarksDetailsResp(@Param("id") long id);
	
	
	
	
}

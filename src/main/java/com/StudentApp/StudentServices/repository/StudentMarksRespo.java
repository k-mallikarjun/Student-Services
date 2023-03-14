package com.StudentApp.StudentServices.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.StudentApp.StudentServices.entity.StudentMarksDetails;

public interface StudentMarksRespo extends JpaRepository<StudentMarksDetails,Integer> {


	


}

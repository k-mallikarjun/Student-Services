package com.StudentApp.StudentServices.entity;

import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="StudentBasicDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBasicDetails {
	
	
			@Id
			@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="StudentBasicDetails_generator")
			private long  studentid;
			
			private String name;
			
			
			private float age;
			
			private String sex;
			
			
			private int standard;
			
			@OneToMany(targetEntity = StudentMarksDetails.class ,cascade = jakarta.persistence.CascadeType.ALL)
			@JoinColumn(name="sbd_fk",referencedColumnName = "studentid")
			private List<StudentMarksDetails> studentMarksDetails;

		/*	public StudentBasicDetails(long studentid, String name, float age, String sex, int standard,
					List<StudentMarksDetails> studentMarksDetails) {
				super();
				this.studentid = studentid;
				this.name = name;
				this.age = age;
				this.sex = sex;
				this.standard = standard;
				this.studentMarksDetails = studentMarksDetails;
			}

			public StudentBasicDetails() {
				super();
				// TODO Auto-generated constructor stub
			}

			public long getStudentid() {
				return studentid;
			}

			public void setStudentid(long studentid) {
				this.studentid = studentid;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public float getAge() {
				return age;
			}

			public void setAge(float age) {
				this.age = age;
			}

			public String getSex() {
				return sex;
			}

			public void setSex(String sex) {
				this.sex = sex;
			}

			public int getStandard() {
				return standard;
			}

			public void setStandard(int standard) {
				this.standard = standard;
			}

			public List<StudentMarksDetails> getStudentMarksDetails() {
				return studentMarksDetails;
			}

			public void setStudentMarksDetails(List<StudentMarksDetails> studentMarksDetails) {
				this.studentMarksDetails = studentMarksDetails;
			}
			
			*/
}

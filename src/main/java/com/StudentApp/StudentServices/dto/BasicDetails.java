package com.StudentApp.StudentServices.dto;

public class BasicDetails {
	
	private long studentid;
	private String name;
	private String sex;
	private int standard;
	public BasicDetails(long studentid, String name, String sex, int standard) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.sex = sex;
		this.standard = standard;
	}
	public BasicDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}

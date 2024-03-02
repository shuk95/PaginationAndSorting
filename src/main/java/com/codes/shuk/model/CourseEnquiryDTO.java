package com.codes.shuk.model;

public class CourseEnquiryDTO {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
	private String studentName;
	private String courseName;
	private int exp;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "StudentEnquiryDTO [studentName=" + studentName + ", courseName=" + courseName + ", exp=" + exp + "]";
	}



}

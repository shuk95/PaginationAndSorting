package com.codes.shuk.service;

import com.codes.shuk.model.CourseEnquiryDTO;
import com.codes.shuk.model.CourseEnquiryPaginationDTO;

import java.util.List;

public interface CourseEnquiryService {
	
	public void saveStudentDetail(CourseEnquiryDTO studentEnquiryDTO);

	List<CourseEnquiryDTO> getAllCourseEnquiry();

	CourseEnquiryDTO findById(int id);


	//CourseEnquiryPaginationDTO findStudentEnquiryPag();

	CourseEnquiryPaginationDTO findStudentEnquiryPag(int pageNum, String fieldName, String sortDir);
}

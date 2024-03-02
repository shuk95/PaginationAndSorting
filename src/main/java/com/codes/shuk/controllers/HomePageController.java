package com.codes.shuk.controllers;

import com.codes.shuk.model.CourseEnquiryDTO;
import com.codes.shuk.model.CourseEnquiryPaginationDTO;
import com.codes.shuk.model.PageInfoDTO;
import com.codes.shuk.service.CourseEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomePageController {
	@Autowired
	private CourseEnquiryService courseEnquiryService;

	@GetMapping(value = {"/","/home"})
	public String showHomePage(Model model) {
		CourseEnquiryDTO studentEnquiryDTO = new CourseEnquiryDTO();
		model.addAttribute("enquiryDTO", studentEnquiryDTO);

		return "home-page";
	}
	@ResponseBody
	@PostMapping("/submitEnquiry")
	public String handleEnquiry(CourseEnquiryDTO studentEnquiryDTO) {
		System.out.println(studentEnquiryDTO); //databinding
		courseEnquiryService.saveStudentDetail(studentEnquiryDTO);
		return "data submitted..";
	}

	@GetMapping("/list")
	public String showCourseEnquiry(Model model){
	//public ResponseEntity<List<CourseEnquiryDTO>> showCourseEnquiry(Model model){

		/*CourseEnquiryPaginationDTO findCourseEnquiryPagination = courseEnquiryService.findStudentEnquiryPag(1);
		List<CourseEnquiryDTO> enquiryDTOs = findCourseEnquiryPagination.getEnquiryDTOs();
		PageInfoDTO pageInfoDTOs = findCourseEnquiryPagination.getPageInfoDTOs();

		model.addAttribute("allCourseEnquiryList",enquiryDTOs);
		model.addAttribute("pageInfo",pageInfoDTOs);*/

		return showCourseEnquiryPagination(1, "id","asc",model);
		//return ResponseEntity.status(HttpStatus.OK).body(allCourseEnquiryDTO);
	}

	@GetMapping("/updateEnquiry")
	public String updateEnquiryDetails(@RequestParam("studentId") int id , Model model) {
		CourseEnquiryDTO courseEnquiryDTO = courseEnquiryService.findById(id);
		System.out.println("courseEnquiryDTO" + courseEnquiryDTO);
		model.addAttribute("enquiryDTO", courseEnquiryDTO);
		return "home-page";
	}

	@GetMapping("/page")
	public String showCourseEnquiryPagination(@RequestParam ("pageNum") int pageNum,
											  @RequestParam (name ="sortField", required = false) String sortField,
											  @RequestParam (name ="sortDir", required = false) String sortDir,
											  Model model){
		System.out.println("SortDir "+ sortDir);
		CourseEnquiryPaginationDTO findCourseEnquiryPagination = courseEnquiryService.findStudentEnquiryPag(pageNum,sortField,sortDir);
		List<CourseEnquiryDTO> enquiryDTOs = findCourseEnquiryPagination.getEnquiryDTOs();
		PageInfoDTO pageInfoDTOs = findCourseEnquiryPagination.getPageInfoDTOs();
		String toggle = sortDir.equals("desc") ? "asc" :"desc";

		model.addAttribute("allCourseEnquiryList",enquiryDTOs);
		model.addAttribute("pageInfo",pageInfoDTOs);
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("reverseSort", toggle);

		return "course-enquiry";

	}

	
	
	
}

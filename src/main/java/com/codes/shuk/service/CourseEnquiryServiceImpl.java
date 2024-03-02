package com.codes.shuk.service;

import com.codes.shuk.entity.CourseEnquiryEntity;
import com.codes.shuk.model.CourseEnquiryDTO;
import com.codes.shuk.model.CourseEnquiryPaginationDTO;
import com.codes.shuk.model.PageInfoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codes.shuk.CourseEnquiryRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseEnquiryServiceImpl implements CourseEnquiryService {

	@Autowired
	private CourseEnquiryRepo courseEnquiryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void saveStudentDetail(CourseEnquiryDTO studentEnquiryDTO) {
		
		//save it by using the dao methods
		// studentEnquiryDTO ->  StudentEnquiryEntity
		
		CourseEnquiryEntity studentEnquiryEntity = modelMapper.map(studentEnquiryDTO, CourseEnquiryEntity.class);

	
		
		courseEnquiryRepo.save(studentEnquiryEntity);
	}
	public List<CourseEnquiryDTO> getAllCourseEnquiry(){

		Sort sort = Sort.by("exp").ascending();

		List<CourseEnquiryEntity> allCourseEnquiries = courseEnquiryRepo.findAll(sort);
		//findStudentEnquiryPag();

		CourseEnquiryDTO[] allCourseEnquiriesDTOArrays = modelMapper.map(allCourseEnquiries, CourseEnquiryDTO[].class);
		return Arrays.asList(allCourseEnquiriesDTOArrays);
	}

	@Override
	public CourseEnquiryDTO findById(int id) {
		CourseEnquiryDTO courseEnquiryDTO=null;

		Optional<CourseEnquiryEntity> courseEnquiryEntity = courseEnquiryRepo.findById(id);
		if(courseEnquiryEntity.isPresent()){
			courseEnquiryEntity.get();
			 courseEnquiryDTO = modelMapper.map(courseEnquiryEntity.get(), CourseEnquiryDTO.class);

		}
		System.out.println("courseEnquiryDTO serviceimpl "+courseEnquiryDTO);


		return courseEnquiryDTO;
	}

	@Override
	public CourseEnquiryPaginationDTO findStudentEnquiryPag(int pageNum, String fieldName, String sortDir){

		CourseEnquiryPaginationDTO courseEnquiryPaginationDTO = new CourseEnquiryPaginationDTO();
		PageInfoDTO pageInfoDTO = new PageInfoDTO();
		Sort sort = Sort.by(fieldName);
		sort = sortDir.equals("asc")?sort.ascending():sort.descending();
		PageRequest pageRequest = PageRequest.of(pageNum-1,3,sort);


		Page<CourseEnquiryEntity> all = courseEnquiryRepo.findAll(pageRequest);
		List<CourseEnquiryEntity> studentEnquiryEntity = all.getContent();
		CourseEnquiryDTO[] mapped = modelMapper.map(studentEnquiryEntity, CourseEnquiryDTO[].class);
		pageInfoDTO.setPageSize(all.getSize());
		pageInfoDTO.setTotalRecords(all.getTotalElements());
		pageInfoDTO.setCurrentPage(pageNum);
		pageInfoDTO.setTotalPages(all.getTotalPages());
		courseEnquiryPaginationDTO.setPageInfoDTOs(pageInfoDTO);
		courseEnquiryPaginationDTO.setEnquiryDTOs(Arrays.asList(mapped));
		return courseEnquiryPaginationDTO;

	}

}

package com.codes.shuk;

import com.codes.shuk.entity.CourseEnquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseEnquiryRepo extends JpaRepository<CourseEnquiryEntity, Integer>{

    List<CourseEnquiryEntity> findAll();

    Optional<CourseEnquiryEntity> findById(Integer integer);
}

package com.codes.shuk.model;

import java.util.List;

public class CourseEnquiryPaginationDTO {

    private List<CourseEnquiryDTO> enquiryDTOs;

    public List<CourseEnquiryDTO> getEnquiryDTOs() {
        return enquiryDTOs;
    }

    public void setEnquiryDTOs(List<CourseEnquiryDTO> enquiryDTOs) {
        this.enquiryDTOs = enquiryDTOs;
    }

    public PageInfoDTO getPageInfoDTOs() {
        return pageInfoDTOs;
    }

    public void setPageInfoDTOs(PageInfoDTO pageInfoDTOs) {
        this.pageInfoDTOs = pageInfoDTOs;
    }

    private PageInfoDTO pageInfoDTOs;
}

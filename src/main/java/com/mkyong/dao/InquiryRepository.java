package com.mkyong.dao;

import com.mkyong.model.Inquiry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends PagingAndSortingRepository<Inquiry,Long> {

}

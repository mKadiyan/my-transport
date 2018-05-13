package com.transport.dao;

import com.transport.model.Inquiry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends PagingAndSortingRepository<Inquiry,Long> {

}

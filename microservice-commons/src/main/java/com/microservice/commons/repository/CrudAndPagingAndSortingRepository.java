package com.microservice.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CrudAndPagingAndSortingRepository<T, ID> extends PagingAndSortingRepository<T, ID>, CrudRepository<T, ID> {

}

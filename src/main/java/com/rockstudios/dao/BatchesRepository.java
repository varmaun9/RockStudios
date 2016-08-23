package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Batches;
/*
*@Author Varma
*/
public interface BatchesRepository  extends PagingAndSortingRepository<Batches, String>, JpaSpecificationExecutor<Batches> {

}

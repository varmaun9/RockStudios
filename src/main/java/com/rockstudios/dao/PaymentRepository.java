package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Payment;
/*
*@Author Sankar
*/
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Serializable>{

}

package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.Payment;
/*
*@Author Sankar
*/
public interface IPaymentService {
	
	Payment create(Payment payment);

	void deletePayment(String paymentId);

	Payment getPayment(String paymentId);

	List<Payment> getAll();

	Payment updatePayment(Payment payment);
}

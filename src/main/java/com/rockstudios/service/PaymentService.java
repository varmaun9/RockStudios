package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.PaymentRepository;
import com.rockstudios.domain.Payment;
/*
*@Author Sankar
*/
@Component
public class PaymentService implements IPaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	@Override
	public Payment create(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public void deletePayment(String paymentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment getPayment(String paymentId) {
		// TODO Auto-generated method stub
		 return paymentRepository.findOne(paymentId);
	}

	@Override
	public List<Payment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
	return paymentRepository.save(payment);
	}

}

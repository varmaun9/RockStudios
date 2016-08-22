package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.PaymentContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.Payment;
import com.rockstudios.model.PaymentModel;
import com.rockstudios.service.PaymentService;

/*
*@Author Sankar
*/

@Service
public class PaymentBusinessDelegate
		implements IBusinessDelegate<PaymentModel, PaymentContext, IKeyBuilder<String>, String> {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public PaymentModel create(PaymentModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, PaymentContext context) {

	}

	@Override
	public PaymentModel edit(IKeyBuilder<String> keyBuilder, PaymentModel model) {
		Payment payment = paymentService.getPayment(keyBuilder.build().toString());
		
		payment = paymentService.updatePayment(payment);
		
		return model;
	}

	@Override
	public PaymentModel getByKey(IKeyBuilder<String> keyBuilder, PaymentContext context) {
		Payment payment = paymentService.getPayment(keyBuilder.build().toString());
		PaymentModel model = conversionService.convert(payment, PaymentModel.class);
		return model;
	}

	@Override
	public Collection<PaymentModel> getCollection(PaymentContext context) {
		List<Payment> payment = new ArrayList<Payment>();
		if (context.getAll() != null) {
			payment = paymentService.getAll();
		}
		List<PaymentModel> paymentModels = (List<PaymentModel>) conversionService.convert(
				payment, TypeDescriptor.forObject(payment),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PaymentModel.class)));
		return paymentModels;
	}

}

package com.rockstudios.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.Payment;
import com.rockstudios.model.PaymentModel;

@Component("paymentToPaymentModelConverter")
public class PaymentToPaymentModelConverter
        implements Converter<Payment, PaymentModel> {
    @Autowired
    private ObjectFactory<PaymentModel> paymentModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PaymentModel convert(final Payment source) {
        PaymentModel paymentModel = paymentModelFactory.getObject();
        BeanUtils.copyProperties(source, paymentModel);

        return paymentModel;
    }

    @Autowired
    public void setPaymentModelFactory(
            final ObjectFactory<PaymentModel> paymentModelFactory) {
        this.paymentModelFactory = paymentModelFactory;
    }
}

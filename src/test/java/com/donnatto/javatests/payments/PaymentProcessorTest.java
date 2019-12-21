package com.donnatto.javatests.payments;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    @Test
    public void paymentIsCorrect() {
        PaymentGateway mock = Mockito.mock(PaymentGateway.class);
        Mockito.when(mock.requestPayment((PaymentRequest) Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor = new PaymentProcessor(mock);

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void paymentIsWrong() {
        PaymentGateway mock = Mockito.mock(PaymentGateway.class);
        Mockito.when(mock.requestPayment((PaymentRequest) Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(mock);

        assertFalse(paymentProcessor.makePayment(1000));
    }
}
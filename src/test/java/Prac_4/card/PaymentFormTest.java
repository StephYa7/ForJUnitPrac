package Prac_4.card;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaymentFormTest {

    @Test
    void payTest() {
        CreditCard creditCard = mock(CreditCard.class);
        PaymentForm paymentForm = new PaymentForm(creditCard);
        paymentForm.pay(123);
        verify(creditCard, times(1)).charge(123);
    }
}
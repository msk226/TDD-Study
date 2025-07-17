package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PaymentData paymentData) {
        return paymentData.getBillingDate().plusMonths(1);
    }
}

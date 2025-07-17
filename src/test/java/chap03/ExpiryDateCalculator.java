package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PaymentData paymentData) {
        if (paymentData.getFirstBillingDate() != null) {
            LocalDate candidateExp = paymentData.getBillingDate().plusMonths(1);
            if (paymentData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        paymentData.getFirstBillingDate().getDayOfMonth()
                );
            }
        }
        return paymentData.getBillingDate().plusMonths(1);
    }
}

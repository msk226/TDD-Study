package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    private static final int ADDED_MONTH = 1;

    public LocalDate calculateExpiryDate(PaymentData paymentData) {
        if (paymentData.getFirstBillingDate() != null) {
            LocalDate candidateExp = paymentData.getBillingDate().plusMonths(ADDED_MONTH);
            if (paymentData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        paymentData.getFirstBillingDate().getDayOfMonth()
                );
            }
        }
        return paymentData.getBillingDate().plusMonths(ADDED_MONTH);
    }
}

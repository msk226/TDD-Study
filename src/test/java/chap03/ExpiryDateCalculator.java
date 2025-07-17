package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {


    public LocalDate calculateExpiryDate(PaymentData paymentData) {

        int addedMonth = paymentData.getPayAmount() / 10_000;

        if (paymentData.getFirstBillingDate() != null) {
            LocalDate candidateExp = paymentData.getBillingDate().plusMonths(addedMonth);
            if (paymentData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        paymentData.getFirstBillingDate().getDayOfMonth()
                );
            }
        }
        return paymentData.getBillingDate().plusMonths(addedMonth);
    }
}

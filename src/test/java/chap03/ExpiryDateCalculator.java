package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {


    public LocalDate calculateExpiryDate(PaymentData paymentData) {

        int addedMonth = paymentData.getPayAmount() / 10_000;

        if (paymentData.getFirstBillingDate() != null) {
            LocalDate candidateExp = paymentData.getBillingDate().plusMonths(addedMonth);
            if (paymentData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                if (YearMonth.from(candidateExp).lengthOfMonth() < paymentData.getFirstBillingDate().getDayOfMonth()) {
                    return candidateExp.withDayOfMonth(YearMonth.from(candidateExp).lengthOfMonth());
                }
                return candidateExp.withDayOfMonth(
                        paymentData.getFirstBillingDate().getDayOfMonth()
                );
            }
        }
        return paymentData.getBillingDate().plusMonths(addedMonth);
    }
}

package chap03;

import java.time.LocalDate;
import java.util.Locale.Builder;

public class PaymentData {
    private LocalDate billingDate;
    private int payAmount;

    private PaymentData() {}

    private PaymentData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate() {
        return this.billingDate;
    }

    public int getPayAmount() {
        return this.payAmount;
    }

    public static PaymentData of(LocalDate billingDate, int payAmount) {
        return new PaymentData(billingDate, payAmount);
    }

}

package chap03;

import java.time.LocalDate;

public class PaymentData {
    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmount;

    private PaymentData() {}

    private PaymentData(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    private PaymentData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getFirstBillingDate() {
        return this.firstBillingDate;
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

    public static PaymentData of(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
        return new PaymentData(firstBillingDate, billingDate, payAmount);
    }

}

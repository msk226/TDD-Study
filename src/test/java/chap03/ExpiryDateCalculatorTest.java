package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

    ExpiryDateCalculator cal = new ExpiryDateCalculator();

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(PaymentData.of(
                LocalDate.of(2025, 4, 1), 10_000),
                LocalDate.of(2025, 5, 1));
        assertExpiryDate(PaymentData.of(
                LocalDate.of(2025, 5, 5), 10_000),
                LocalDate.of(2025,6, 5));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(PaymentData.of(
                LocalDate.of(2025, 1, 31), 10_000),
                LocalDate.of(2025, 2, 28));
        assertExpiryDate(PaymentData.of(
                LocalDate.of(2025, 5, 31), 10_000),
                LocalDate.of(2025, 6, 30));
        assertExpiryDate(PaymentData.of(
                LocalDate.of(2020, 1, 31), 10_000),
                LocalDate.of(2020, 2, 29));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        assertExpiryDate(PaymentData.of(
                LocalDate.of(2025,1, 31),
                LocalDate.of(2025, 2, 28),
                10_000
        ), LocalDate.of(2025, 3, 31));

        assertExpiryDate(PaymentData.of(
                LocalDate.of(2025,1, 30),
                LocalDate.of(2025, 2, 28),
                10_000
        ), LocalDate.of(2025, 3, 30));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산() {
        assertExpiryDate(
                PaymentData.of(
                        LocalDate.of(2025, 3, 1),
                        20_000
                ), LocalDate.of(2025, 5, 1)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
        assertExpiryDate(
                PaymentData.of(
                        LocalDate.of(2025, 1, 31),
                        LocalDate.of(2025, 2, 28),
                        20_000
                ), LocalDate.of(2025, 4, 30)
        );

        assertExpiryDate(
                PaymentData.of(
                        LocalDate.of(2025, 3, 31),
                        LocalDate.of(2025, 4, 28),
                        30_000
                ), LocalDate.of(2025, 7, 31)
        );
    }

    private void assertExpiryDate(
            PaymentData paymentData, LocalDate expectedExpiryDate) {
        LocalDate expiryDate = cal.calculateExpiryDate(paymentData);
        assertEquals(expectedExpiryDate, expiryDate);
    }

}

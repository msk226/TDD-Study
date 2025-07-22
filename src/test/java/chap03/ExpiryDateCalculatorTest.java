package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(LocalDate.of(2025, 4, 1), 10_000, LocalDate.of(2025, 5, 1));
        assertExpiryDate(LocalDate.of(2025, 5, 5), 10_000, LocalDate.of(2025,6, 5));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(LocalDate.of(2025, 1, 31), 10_000, LocalDate.of(2025, 2, 28));
        assertExpiryDate(LocalDate.of(2025, 5, 31), 10_000, LocalDate.of(2025, 6, 30));
        assertExpiryDate(LocalDate.of(2020, 1, 31), 10_000, LocalDate.of(2020, 2, 29));
    }

    private void assertExpiryDate(
            LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate
    ) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, expiryDate);
    }

}

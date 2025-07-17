package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        LocalDate billingDate = LocalDate.of(2025, 3, 1);

        assertExpiryDate(LocalDate.of(2025, 4, 1), 10_000, LocalDate.of(2025, 5, 1));
        assertExpiryDate(LocalDate.of(2025, 5, 5), 10_000, LocalDate.of(2025,6, 5));
    }

    private void assertExpiryDate(
            LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate
    ) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, expiryDate);
    }

}

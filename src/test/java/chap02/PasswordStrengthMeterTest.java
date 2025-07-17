package chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    @Test
    void plus() {
        int result = Calculator.plus(1, 2);

        Assertions.assertEquals(3, result);
    }
}

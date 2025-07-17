package chap02;

import static org.junit.jupiter.api.Assertions.*;

import kr.chap02.Calculator;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    @Test
    void name() {
        // 가장 쉽거나 가장 예외적인 경우 먼저 테스트.
        // 모든 규칙을 충족하거나, 모든 조건을 충족하지 않는 경우
        // 모든 조건을 충족하지 않는 경우는 사실상 구현을 다 하고 테스트 하는 방식과 다르지 않음
    }

    @Test
    void meetAllCriteriaThenStrong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
    }
}

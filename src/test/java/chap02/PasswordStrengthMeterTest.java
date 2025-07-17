package chap02;

import static org.junit.jupiter.api.Assertions.*;

import kr.chap02.Calculator;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    @Test
    void name() {
        // 가장 쉽거나 가장 예외적인 경우 먼저 테스트.
        // 모든 규칙을 충족하거나, 모든 조건을 충족하지 않는 경우
        // 모든 조건을 충족하지 않는 경우는 사실상 구현을 다 하고 테스트 하는 방식과 다르지 않음
    }

    @Test
    void meetAllCriteriaThenStrong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteriaExceptForLengthThenNormal() {
        assertStrength("ab12!@a", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteriaExceptForNumberThenNormals() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    void 값이_없는_경우_INVALID를_리턴한다() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void 대문자를_포함하지_않고_나머지_조건을_충족하는_경우() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    void 길이가_8글자_이상인_조건만_충족하는_경우() {
        assertStrength("abdefght", PasswordStrength.WEEK);
    }

    private void assertStrength(String s, PasswordStrength normal) {
        PasswordStrength result = meter.meter(s);
        assertEquals(normal, result);
    }


}

package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null) return PasswordStrength.INVALID;

        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }

        if (meetsContainingNumberCriteria(s) || meetsContainingUppercaseCriteria(s)) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}

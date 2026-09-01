class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if string is empty after removing spaces
        if (i == n) {
            return 0;
        }

        // 2. Check for sign indicator
        if (s.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // 3. Convert digits and prevent overflow
        while (i < n) {
            char ch = s.charAt(i);
            
            // Stop if the character is not a valid digit
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // Check for 32-bit signed integer overflow bounds
            // Integer.MAX_VALUE = 2147483647, Integer.MIN_VALUE = -2147483648
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}


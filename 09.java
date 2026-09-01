class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes (e.g., -121 reads as 121-)
        // 2. Numbers ending in 0 are not palindromes, unless the number itself is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // Reverse the digits of the second half of the number
        while (x > revertedNumber) {
            revertedNumber = (revertedNumber * 10) + (x % 10);
            x /= 10;
        }

        // For even-length numbers (e.g., 1221), x will equal revertedNumber (12 == 12)
        // For odd-length numbers (e.g., 12321), we discard the middle digit: x == revertedNumber / 10 (12 == 123 / 10)
        return x == revertedNumber || x == revertedNumber / 10;
    }
}


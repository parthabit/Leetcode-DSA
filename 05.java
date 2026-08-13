class Solution {
    public String longestPalindrome(String s) {

        String answer = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String part = s.substring(i, j);

                if (isPalindrome(part)) {

                    if (part.length() > answer.length()) {
                        answer = part;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

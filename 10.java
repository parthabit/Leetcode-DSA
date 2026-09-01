class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* that can match an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    // Current characters match, look at diagonally top-left state
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Case 1: Count '*' as zero occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Count '*' as one or more occurrences
                    // If preceding character matches current text character (or is '.')
                    char precedingChar = p.charAt(j - 2);
                    if (precedingChar == sc || precedingChar == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}


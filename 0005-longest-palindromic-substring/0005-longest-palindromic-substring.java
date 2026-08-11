class Solution {

    public boolean helper(String s, int i, int j, Boolean[][] dp) {
        if (i >= j)
            return true;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) != s.charAt(j))
            return false;
        dp[i][j] = helper(s, i + 1, j - 1, dp);

        return dp[i][j];
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLen = 1;
        Boolean[][] dp = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (helper(s, i, j, dp)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start+maxLen);
    }
}
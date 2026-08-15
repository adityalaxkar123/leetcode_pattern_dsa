class Solution {

    public boolean helper(String s1, String s2, int i, int j, Boolean[][] dp) {
        if (i < 0) {
            int k = j;
            while (k >= 1) {
                if (s2.charAt(k) != '*')
                    return false;
                k -= 2;
            }
            return k < 0;
        }
        if (j < 0)
            return false;
        if (i == 0 && j == 0) {
            if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.')
                return true;
            return false;
        }
        if (dp[i][j] != null)
            return dp[i][j];

        boolean pick = false, nopick = false;
        if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.')
            pick = helper(s1, s2, i - 1, j - 1, dp);
        else if (j - 1 >= 0 && s2.charAt(j) == '*') {
            if (s1.charAt(i) == s2.charAt(j-1) || s2.charAt(j-1) == '.')
                pick = helper(s1, s2, i - 1, j, dp) || helper(s1, s2, i, j - 2, dp);
            else
                pick = helper(s1, s2, i, j - 2, dp);

        } else
            return dp[i][j] = false;

        dp[i][j] = pick;
        return dp[i][j];
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];

        return helper(s, p, n - 1, m - 1, dp);
    }
}
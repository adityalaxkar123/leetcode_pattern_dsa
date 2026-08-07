class Solution {
    public int helper(String s, String t, int i, int j, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int pick = 0;
        if (s.charAt(i) == t.charAt(j))
            pick = helper(s, t, i - 1, j - 1, dp);
        int nopick = helper(s, t, i - 1, j, dp);
        dp[i][j] = pick + nopick;
        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int []prev = new int[m+1];
        prev[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            int []curr = new int[m+1];
            curr[0]=1;
            for (int j = 1; j < m + 1; j++) {
                int pick = 0;
                if (s.charAt(i-1) == t.charAt(j-1))
                    pick = prev[j-1];
                int nopick = prev[j];
                curr[j] = pick + nopick;
            }
            prev = curr;
        }

        return prev[m];
    }
}
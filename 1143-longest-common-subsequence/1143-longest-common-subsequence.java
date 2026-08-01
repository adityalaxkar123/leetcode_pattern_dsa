class Solution {

    // public int helper(String s, String t, int idx1, int idx2, int[][] dp) {
    //     if (idx2 < 0)
    //         return 0;
    //     if (idx1 < 0)
    //         return 0;
    //     if (idx1 == 0 && idx2 == 0) {
    //         if (s.charAt(idx1) == t.charAt(idx2)) {
    //             dp[idx1][idx2] = 1;
    //             return dp[idx1][idx2];
    //         }
    //         dp[idx1][idx2] = 0;
    //         return dp[idx1][idx2];
    //     }
    //     if (dp[idx1][idx2] != -1)
    //         return dp[idx1][idx2];
    //     int pick = 0;
    //     int nopick1 = 0, nopick2 = 0;
    //     if (s.charAt(idx1) == t.charAt(idx2)) {
    //         pick = 1 + helper(s, t, idx1 - 1, idx2 - 1, dp);
    //     } else {
    //         nopick1 = helper(s, t, idx1 - 1, idx2, dp);
    //         nopick2 = helper(s, t, idx1, idx2 - 1, dp);
    //     }
    //     dp[idx1][idx2] = Math.max(pick, Math.max(nopick1, nopick2));
    //     return dp[idx1][idx2];
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // int[][] dp = new int[n][m];
        int[] prev = new int[m];
        if (text1.charAt(0) == text2.charAt(0)) {
            prev[0] = 1;
        } else
            prev[0] = 0;
        for (int i = 1; i < m; i++) {
            if (text1.charAt(0) == text2.charAt(i)) {
                prev[i] = 1;
            } else
                prev[i] = prev[i - 1];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];
            if (text1.charAt(i) == text2.charAt(0)) {
                curr[0] = 1;
            } else
                curr[0] = prev[0];
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + prev[j - 1];
                } else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}
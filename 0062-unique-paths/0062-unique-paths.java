class Solution {

    public int helper(int[][] dp, int i, int j) {
        int m = dp.length;
        int n = dp[0].length;
        if (i >= m)
            return 0;
        if (j >= n)
            return 0;
        if (i == m - 1 && j == n - 1) {
            dp[i][j] = 1;
            return dp[i][j];
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int right = helper(dp, i, j + 1);
        int bottom = helper(dp, i + 1, j);
        dp[i][j] = right + bottom;
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        int []next = new int[n];
        next[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            int []curr = new int[n];
            curr[n-1]=1;
            for (int j = n - 1; j >= 0; j--) {
                if(i==m-1 && j==n-1)
                    continue;
                int right=0,bottom=0;
                if(j+1<n)
                    right = curr[j+1];
                if(i+1<m)
                    bottom = next[j];
                curr[j] = right + bottom;
            }
            next=curr;
        }
        return next[0];
    }
}
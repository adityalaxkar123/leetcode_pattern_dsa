class Solution {

    public int helper(int[][] arr, int i, int j, int[][] dp) {
        int n = arr.length;
        int m = arr[0].length;
        if (i >= n || j >= m)
            return Integer.MAX_VALUE;
        if (i == n - 1 && j == m - 1) {
            dp[i][j] = arr[i][j];
            return dp[i][j];
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int right = helper(arr, i, j + 1, dp);
        int left = helper(arr, i + 1, j, dp);
        dp[i][j] = arr[i][j] + Math.min(right, left);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // int[][] dp = new int[n][m];
        int []next = new int[m];
        // if (i >= n || j >= m)
        //     return Integer.MAX_VALUE;
        // if (i == n - 1 && j == m - 1) {
        //     dp[i][j] = arr[i][j];
        //     return dp[i][j];
        // }
        next[m - 1] = grid[n - 1][m - 1];
        for (int i = n - 1; i >= 0; i--) {
            int []curr = new int[m];
            curr[m-1]=next[m-1];
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1)
                    continue;
                int right = Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                if(j+1<m)
                    right = curr[j+1];
                if(i+1<n)
                    left = next[j];
                curr[j] = grid[i][j] + Math.min(right, left);
            }
            next = curr;
        }
        // for(int i=0;i<n;i++)
        //     Arrays.fill(dp[i],-1);
        // return helper(grid,0,0,dp);
        return next[0];
    }
}
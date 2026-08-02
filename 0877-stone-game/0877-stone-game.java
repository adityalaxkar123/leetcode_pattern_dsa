class Solution {

    public int helper(int[] nums, int st, int end, int[][] dp) {
        if (st == end)
            return nums[st];
        if (dp[st][end] != -1)
            return dp[st][end];
        int leftPick = nums[st] - helper(nums, st + 1, end, dp);
        int rightPick = nums[end] - helper(nums, st, end - 1, dp);
        dp[st][end] = Math.max(leftPick, rightPick);
        return dp[st][end];
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // int[][] dp = new int[n][n];
        int []prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = piles[i];
        }

        for (int i = n-1; i >= 0; i--) {
            int []curr = new int[n];
            curr[i]=piles[i];
            for (int j = i+1; j < n; j++) {
                int leftPick = piles[i] - prev[j];
                int rightPick = piles[j] - curr[j-1];
                curr[j] = Math.max(leftPick, rightPick);
            }
            prev = curr;
        }

        // return helper(piles,0,n-1,dp)>0;
        return prev[n-1]>0;
    }
}
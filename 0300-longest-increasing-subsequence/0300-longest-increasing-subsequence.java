class Solution {

    // public int helper(int[] nums, int idx, int prevIdx, int[][] dp) {
    //     if (idx == 0) {
    //         if (prevIdx == nums.length || nums[idx] < nums[prevIdx]) {
    //             dp[idx][prevIdx] = 1;
    //             return dp[idx][prevIdx];
    //         }
    //         dp[idx][prevIdx] = 0;
    //         return dp[idx][prevIdx];
    //     }
    //     if (dp[idx][prevIdx] != -1)
    //         return dp[idx][prevIdx];
    //     int pick = 0;
    //     if (prevIdx == nums.length) {
    //         pick = 1 + helper(nums, idx - 1, idx, dp);
    //     } else if (nums[idx] < nums[prevIdx])
    //         pick = 1 + helper(nums, idx - 1, idx, dp);
    //     int nopick = helper(nums, idx - 1, prevIdx, dp);
    //     dp[idx][prevIdx] = Math.max(pick, nopick);
    //     return dp[idx][prevIdx];
    // }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int[][] dp = new int[n][n + 1];
        int []prev = new int[n+1];
        if (nums.length == 1)
            return 1;
        for (int i = 0; i < n + 1; i++) {
            if (i== nums.length || nums[0] < nums[i]) {
                prev[i] = 1;
            } else {
                prev[i] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int []curr = new int[n+1];
            for (int j = 1; j < n + 1; j++) {
                int pick = 0;
                if (j == nums.length || nums[i]<nums[j]) {
                    pick = 1 + prev[i];
                }
                int nopick = prev[j];
                curr[j] = Math.max(pick, nopick);
            }
            prev = curr;
        }

        // return helper(nums,n-1,n,dp);
        return prev[n];
    }
}
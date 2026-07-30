class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int n = nums.length;
        int []dp = new int[n];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],nums[i]+((i-3>=0)?dp[i-3]:0));
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
}
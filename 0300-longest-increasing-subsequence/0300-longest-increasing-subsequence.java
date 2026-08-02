class Solution {

    public int helper(int []nums,int idx,int prevIdx,int [][]dp){
        if(idx==0){
            if(prevIdx == nums.length || nums[idx]<nums[prevIdx]){
                dp[idx][prevIdx]=1;
                return dp[idx][prevIdx];
            }
            dp[idx][prevIdx]=0;
            return dp[idx][prevIdx];
        }
        if(dp[idx][prevIdx]!=-1)
            return dp[idx][prevIdx];
        int pick = 0;
        if(prevIdx==nums.length){
            pick = 1+helper(nums,idx-1,idx,dp);
        }
        else if(nums[idx]<nums[prevIdx])
            pick = 1+helper(nums,idx-1,idx,dp);
        int nopick = helper(nums,idx-1,prevIdx,dp);
        dp[idx][prevIdx]=Math.max(pick,nopick);
        return dp[idx][prevIdx];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n][n+1];
        if(nums.length==1)
            return 1;
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,n-1,n,dp);
    }
}
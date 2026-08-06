class Solution {

    public boolean helper(int []nums,int idx,int sum,int [][]dp){
        if(sum==0)
            return true;
        if(idx==0){
            if(sum-nums[idx]==0)
                return true;
            return false;
        }
        if(dp[idx][sum]!=0){
            return (dp[idx][sum]==1)?true:false;
        }
        boolean pick = false,nopick = false;
        if(sum-nums[idx]>=0)
            pick = helper(nums,idx-1,sum-nums[idx],dp);
        nopick = helper(nums,idx-1,sum,dp);
        dp[idx][sum]=(pick || nopick)?1:2;

        return (dp[idx][sum]==1)?true:false;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i : nums){
            total+=i;
        }
        int n = nums.length;
        if(total%2!=0)
            return false;
        int [][]dp = new int[n][total/2 + 1];

        return helper(nums,n-1,total/2,dp);
    }
}
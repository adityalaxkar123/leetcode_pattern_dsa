class Solution {

    public int helper(int []arr,int idx,int sum,int [][]dp){
      
        if(idx>=arr.length){
            if(sum==0)
                return 1;
            return 0;
        }
        if(dp[idx][sum]!=-1)
            return dp[idx][sum];
        int pick=0,nopick=0;
        if(sum-arr[idx]>=0)
            pick = helper(arr,idx+1,sum-arr[idx],dp);
        nopick = helper(arr,idx+1,sum,dp);
        dp[idx][sum]=pick+nopick;
        return dp[idx][sum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total=0;
        for(int i : nums)
            total+=i;
        if((total+target)%2!=0 || total<Math.abs(target))
            return 0;
        int sum = (total+target)/2;
        int [][]dp = new int[n][sum+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return helper(nums,0,sum,dp);
    }
}
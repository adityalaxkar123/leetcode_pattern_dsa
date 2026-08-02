class Solution {

    public int helper(int []nums,int st,int end,int [][]dp){
        if(st==end)
            return nums[st];
        if(dp[st][end]!=-1)
            return dp[st][end];
        int leftPick = nums[st] - helper(nums,st+1,end,dp);
        int rightPick = nums[end] - helper(nums,st,end-1,dp);
        dp[st][end]=Math.max(leftPick,rightPick);
        return dp[st][end];
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(piles,0,n-1,dp)>0;
    }
}
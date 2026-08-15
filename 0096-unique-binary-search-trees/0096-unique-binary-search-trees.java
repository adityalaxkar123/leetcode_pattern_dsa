class Solution {

    public int helper(int n,int []dp){
        if(n<=1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];

        int ans = 0;
        for(int root=1;root<=n;root++){
            ans+=helper(root-1,dp)*helper(n-root,dp);
        }
        return dp[n]=ans;
    }

    public int numTrees(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);

        return helper(n,dp);
    }
}
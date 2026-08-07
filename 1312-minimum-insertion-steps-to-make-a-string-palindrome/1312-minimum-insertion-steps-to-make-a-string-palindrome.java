class Solution {

    public int helper(String s,int st,int end,int [][]dp){
        if(st>end)
            return 0;
        if(st==end){
            if(s.charAt(st)==s.charAt(end))
                return 1;
            return 0;
        }
        if(dp[st][end]!=-1)
            return dp[st][end];
        int pick = 0;
        if(s.charAt(st)==s.charAt(end)){
            pick = 2 + helper(s,st+1,end-1,dp);
        }
        int np1 = helper(s,st+1,end,dp);
        int np2 = helper(s,st,end-1,dp);
        dp[st][end]=Math.max(pick,Math.max(np1,np2));

        return dp[st][end];
    }

    public int minInsertions(String s) {
        int n = s.length();
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        return n - helper(s,0,n-1,dp);
    }
}
class Solution {
    public int helper(String s,int st,int end,int [][]dp){
        if(st>end)
            return 0;
        if(st==end){
            if(s.charAt(st)==s.charAt(end)){
                dp[st][end]=1;
                return dp[st][end];
            }
            dp[st][end]=0;
            return dp[st][end];
        }
        if(dp[st][end]!=-1)
            return dp[st][end];
        if(s.charAt(st)==s.charAt(end)){
            dp[st][end] = 2+helper(s,st+1,end-1,dp);
            return dp[st][end];
        }
        dp[st][end] = Math.max(helper(s,st+1,end,dp),helper(s,st,end-1,dp)); 
        return dp[st][end];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,0,n-1,dp);
    }
}
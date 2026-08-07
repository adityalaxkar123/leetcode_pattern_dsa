class Solution {

    public int helper(String s1,String s2,int idx1,int idx2,int [][]dp){
        if(idx1<0 || idx2<0)
            return 0;
        
        if(idx1==0 && idx2==0){
            if(s1.charAt(idx1)==s2.charAt(idx2))
                return 1;
            return 0;
        }
        if(dp[idx1][idx2]!=-1)
            return dp[idx1][idx2];
        int pick = 0;
        if(s1.charAt(idx1)==s2.charAt(idx2))
            pick = 1 + helper(s1,s2,idx1-1,idx2-1,dp);
        int np1 = helper(s1,s2,idx1-1,idx2,dp);
        int np2 = helper(s1,s2,idx1,idx2-1,dp);
        dp[idx1][idx2] = Math.max(pick,Math.max(np1,np2));

        return dp[idx1][idx2];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return n+m-2*helper(word1,word2,n-1,m-1,dp);
    }
}
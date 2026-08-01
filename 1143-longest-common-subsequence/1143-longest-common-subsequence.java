class Solution {

    public int helper(String s,String t,int idx1,int idx2,int [][]dp){
        if(idx2<0)
            return 0;
        if(idx1<0)
            return 0;
        if(idx1==0 && idx2==0){
            if(s.charAt(idx1)==t.charAt(idx2)){
                dp[idx1][idx2]=1;
                return dp[idx1][idx2];
            }
            dp[idx1][idx2]=0;
            return dp[idx1][idx2];
        }
        if(dp[idx1][idx2]!=-1)
            return dp[idx1][idx2];
        int pick = 0;
        int nopick1=0,nopick2=0;
        if(s.charAt(idx1)==t.charAt(idx2)){
            pick = 1+helper(s,t,idx1-1,idx2-1,dp);
        }else{
         nopick1 = helper(s,t,idx1-1,idx2,dp);
         nopick2 = helper(s,t,idx1,idx2-1,dp);
        }
        dp[idx1][idx2]=Math.max(pick,Math.max(nopick1,nopick2));
        return dp[idx1][idx2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        // for(int i=1;i<m;i++){
        //     max = Math.max(max,helper(text1,text2,n-1,m-i));
        // }
        return helper(text1,text2,n-1,m-1,dp);
    }
}
class Solution {

    public boolean helper(String s1,String s2,int idx1,int idx2,int [][]dp){
        if(idx2<0)
            return true;
        if(idx1<0 && idx2>=0)
            return false;

        if(dp[idx1][idx2]!=0)
            return dp[idx1][idx2]==1?true:false;
        boolean pick = false,nopick=false;
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            pick = helper(s1,s2,idx1-1,idx2-1,dp);
        }
        nopick = helper(s1,s2,idx1-1,idx2,dp);
        dp[idx1][idx2] =(pick || nopick)?1:2; 
        return dp[idx1][idx2]==1?true:false;
    }

    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        int [][]dp = new int[n][m];
        return helper(t,s,n-1,m-1,dp);
    }
}
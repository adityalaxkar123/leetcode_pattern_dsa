class Solution {

    public boolean helper(String s1, String s2, String s3,int i,int j,Boolean [][]dp){
        if(i==0 && j==0)
            return true;
        if(dp[i][j]!=null)
            return dp[i][j];
        boolean pick = false;
        if(i-1>=0 && s1.charAt(i-1)==s3.charAt(i+j-1) && j-1>=0 && s2.charAt(j-1)==s3.charAt(i+j-1)){
            pick = helper(s1,s2,s3,i-1,j,dp) || helper(s1,s2,s3,i,j-1,dp);
        }else if(i-1>=0 && s1.charAt(i-1)==s3.charAt(i+j-1)){
            pick = helper(s1,s2,s3,i-1,j,dp);
        }else if(j-1>=0 && s2.charAt(j-1)==s3.charAt(i+j-1)){
            pick = helper(s1,s2,s3,i,j-1,dp);
        }else{
            return dp[i][j]=false;
        }

        return dp[i][j]=pick;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if(k!=n+m)
            return false;

        Boolean [][]dp = new Boolean[n+1][m+1];
        return helper(s1,s2,s3,n,m,dp); 
    }
}
class Solution {

    public boolean helper(String s1,String s2,int i,int j,int [][]dp){
        if(i<0){
            int k = j;
            while(k>=0){
                if(s2.charAt(k)!='*')
                    return false;
                k--;
            }
            return true;
        }
        if(j<0){
            if(i>=0)
                return false;
            return true;
        }
        if(dp[i][j]!=0)
            return (dp[i][j]==1)?true:false;
        
        boolean match = false,notMatch=false;
        if(s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='?')
            match = helper(s1,s2,i-1,j-1,dp);
        else if(s2.charAt(j)=='*')
            notMatch = helper(s1,s2,i-1,j,dp) || helper(s1,s2,i,j-1,dp);
        else
           return false;
        dp[i][j] = (match || notMatch)?1:2;
        return (dp[i][j]==1)?true:false;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int [][]dp = new int[n][m];
        return helper(s,p,n-1,m-1,dp);
    }
}
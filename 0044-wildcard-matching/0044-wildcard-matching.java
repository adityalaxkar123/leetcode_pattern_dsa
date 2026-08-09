class Solution {

    public boolean helper(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0) {
            int k = j;
            while (k >= 0) {
                if (s2.charAt(k) != '*')
                    return false;
                k--;
            }
            return true;
        }
        if (j < 0) {
            if (i >= 0)
                return false;
            return true;
        }
        if (dp[i][j] != 0)
            return (dp[i][j] == 1) ? true : false;

        boolean match = false, notMatch = false;
        if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?')
            match = helper(s1, s2, i - 1, j - 1, dp);
        else if (s2.charAt(j) == '*')
            notMatch = helper(s1, s2, i - 1, j, dp) || helper(s1, s2, i, j - 1, dp);
        else
            return false;
        dp[i][j] = (match || notMatch) ? 1 : 2;
        return (dp[i][j] == 1) ? true : false;
    }

    public boolean isMatch(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int [][]dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            dp[i][0]=2;
        }
        dp[0][0]=1;
        for(int j=1;j<m+1;j++){
            int k = j;
            boolean ans = true;
            while(k>0){
                if(s2.charAt(k-1)!='*'){
                    ans=false;
                    break;
                }
                k--;
            }
            if(ans)
                dp[0][j]=1;
            else
                dp[0][j]=2;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                int match = 2,notMatch=2;
                dp[i][j]=2;
                if(s1.charAt(i-1)==s2.charAt(j-1) || s2.charAt(j-1)=='?')
                    match = dp[i-1][j-1];
                else if(s2.charAt(j-1)=='*')
                    notMatch = (dp[i-1][j]==1 || dp[i][j-1]==1)?1:2;
                dp[i][j] = (match==1 || notMatch==1)?1:2;
            }
        }
       
       return dp[n][m]==1?true:false;
    }
}
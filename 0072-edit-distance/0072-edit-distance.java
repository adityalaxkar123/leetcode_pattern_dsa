class Solution {

    public int helper(String s1,String s2,int i,int j,int [][]dp){
        if(j<0){
            return i+1;
        }
        if(i<0){
            return j+1;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int insert = Integer.MAX_VALUE,replace=Integer.MAX_VALUE,remove=Integer.MAX_VALUE,equal=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            equal = 0 + helper(s1,s2,i-1,j-1,dp);
        }else{
            replace = 1 + helper(s1,s2,i-1,j-1,dp);
            remove = 1 + helper(s1,s2,i-1,j,dp);
            insert = 1 + helper(s1,s2,i,j-1,dp);
        }
        dp[i][j] = Math.min(equal,Math.min(replace,Math.min(remove,insert)));

        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(word1,word2,n-1,m-1,dp);
    }
}
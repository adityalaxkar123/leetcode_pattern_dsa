class Solution {

    public int helper(int [][]dp,int i,int j){
        int m = dp.length;
        int n = dp[0].length;
        if(i>=m)
            return 0;
        if(j>=n)
            return 0;
        if(i==m-1 && j==n-1){
            dp[i][j]=1;
            return dp[i][j];
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int right = helper(dp,i,j+1);
        int bottom = helper(dp,i+1,j);
        dp[i][j] = right+bottom;
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        return helper(dp,0,0);
    }
}
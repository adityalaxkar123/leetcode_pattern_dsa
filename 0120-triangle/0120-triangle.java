class Solution {

    public int helper(List<List<Integer>> triangle,int i,int j,int [][]dp){
        int n = triangle.size();
        if(i==n-1)
            return triangle.get(i).get(j);
        if(dp[i][j]!=Integer.MAX_VALUE)
            return dp[i][j];
        int down = helper(triangle,i+1,j,dp);
        int diagonal = helper(triangle,i+1,j+1,dp);
        dp[i][j] = triangle.get(i).get(j) + Math.min(down,diagonal);

        return dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        return helper(triangle,0,0,dp);
    }
}
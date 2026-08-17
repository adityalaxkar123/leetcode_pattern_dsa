class Solution {

    public int helper(int [][]grid,int i,int j,int [][]dp){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int top=0,down=0,left=0,right=0;
        //top
        if(i-1>=0 && grid[i-1][j]>grid[i][j])
            top=helper(grid,i-1,j,dp);
        //bottom
        if(i+1<grid.length && grid[i+1][j]>grid[i][j])
            down=helper(grid,i+1,j,dp);
        //left
        if(j-1>=0 && grid[i][j-1]>grid[i][j])
            left=helper(grid,i,j-1,dp);
        //right
        if(j+1<grid[0].length && grid[i][j+1]>grid[i][j])
            right=helper(grid,i,j+1,dp);

        return dp[i][j]=1+Math.max(top,Math.max(down,Math.max(left,right)));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 1;
        int [][]dp = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans,helper(matrix,i,j,dp));
            }
        }


        return ans;
    }
}
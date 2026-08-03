class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1)
            return 0;
        int []next = new int[n];
        next[n-1]=1;

        for(int i=m-1;i>=0;i--){
            int []curr = new int[n];
            curr[n-1]=1;
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1)
                    continue;
                int right=0,bottom=0;
                if(i+1<m && obstacleGrid[i+1][j]!=1)
                    right=next[j];
                if(j+1<n && obstacleGrid[i][j+1]!=1)
                    bottom=curr[j+1];
                curr[j]=right+bottom;
            }
            next=curr;
        }

        return next[0];
    }
}
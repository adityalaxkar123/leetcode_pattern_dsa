class Solution {

    public int helper(int [][]grid,int r,int c,int [][]dp){
        if(r==grid.length-1 && c==grid[0].length-1)
            return -(grid[r][c]);
        if(dp[r][c]!=1001){
            return dp[r][c];
        }
        int right = Integer.MAX_VALUE,bottom = Integer.MAX_VALUE;
        if(c+1<grid[0].length)
            right = helper(grid,r,c+1,dp);
        if(r+1<grid.length)
            bottom = helper(grid,r+1,c,dp);
        int minHeal = -(grid[r][c]) + Math.min(right,bottom);

        return dp[r][c]=Math.max(-(grid[r][c]),minHeal);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length==1 && dungeon[0].length==1){
            return dungeon[0][0]>0?1:-(dungeon[0][0])+1;
        }
        int n = dungeon.length;
        int m = dungeon[0].length;
        int [][]dp = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],1001);
        int ans = helper(dungeon,0,0,dp);

        return (ans<0)?1:ans+1;
    }
}
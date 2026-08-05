class Solution {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int []next = new int[m];
        next[m - 1] = grid[n - 1][m - 1];
        for (int i = n - 1; i >= 0; i--) {
            int []curr = new int[m];
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1){
                    curr[m-1]=grid[n-1][m-1];
                    continue;
                }
                int right = Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                if(j+1<m)
                    right = curr[j+1];
                if(i+1<n)
                    left = next[j];
                curr[j] = grid[i][j] + Math.min(right, left);
            }
            next = curr;
        }
        return next[0];
    }
}
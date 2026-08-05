class Solution {

    public int helper(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        int n = triangle.size();
        if (i == n - 1)
            return triangle.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        int down = helper(triangle, i + 1, j, dp);
        int diagonal = helper(triangle, i + 1, j + 1, dp);
        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);

        return dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // int [][]dp = new int[n][n];
        int[] next = new int[n];
        for(int i=0;i<n;i++){
            next[i]=triangle.get(n-1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            int []curr = new int[n];
            for (int j = i; j >= 0; j--) {
                if(i==n-1){
                    curr[j]=triangle.get(i).get(j);
                    continue;
                }
                int down = next[j];
                int diagonal = next[j+1];
                curr[j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }
            next=curr;
        }
        return next[0];
    }
}
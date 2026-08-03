class Solution {

    public int helper(int[][] pairs, int idx, int prevIdx, int[][] dp) {
        int n = pairs.length;
        if (idx == 0) {
            if (prevIdx == n || pairs[idx][1] < pairs[prevIdx][0]) {
                dp[idx][prevIdx] = 1;
                return dp[idx][prevIdx];
            }
            dp[idx][prevIdx] = 0;
            return dp[idx][prevIdx];
        }
        if (dp[idx][prevIdx] != -1)
            return dp[idx][prevIdx];
        int pick = 0;
        if (prevIdx == n || pairs[idx][1] < pairs[prevIdx][0])
            pick = 1 + helper(pairs, idx - 1, idx, dp);
        int nopick = helper(pairs, idx - 1, prevIdx, dp);
        dp[idx][prevIdx] = Math.max(pick, nopick);
        return dp[idx][prevIdx];
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[][] dp = new int[n][n + 1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });
        return helper(pairs, n - 1, n, dp);
    }
}
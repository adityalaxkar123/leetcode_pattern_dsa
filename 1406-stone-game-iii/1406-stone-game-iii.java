class Solution {

    // public int helper(int[] arr, int st, int[] dp) {
    //     int n = arr.length;
    //     if (st >= n)
    //         return 0;
    //     int pickOne = Integer.MIN_VALUE, pickTwo = Integer.MIN_VALUE, pickThree = Integer.MIN_VALUE;
    //     if (dp[st] != -1)
    //         return dp[st];
    //     if (st + 2 < n)
    //         pickThree = arr[st] + arr[st + 1] + arr[st + 2] - helper(arr, st + 3, dp);
    //     if (st + 1 < n)
    //         pickTwo = arr[st] + arr[st + 1] - helper(arr, st + 2, dp);
    //     if (st < n)
    //         pickOne = arr[st] - helper(arr, st + 1, dp);

    //     dp[st] = Math.max(pickThree, Math.max(pickTwo, pickOne));
    //     return dp[st];
    // }

    public String stoneGameIII(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+3];
        for (int i = n-1; i >= 0; i--) {
            int pickOne = Integer.MIN_VALUE, pickTwo = Integer.MIN_VALUE, pickThree = Integer.MIN_VALUE;
            if (i + 2 < n)
                pickThree = arr[i] + arr[i + 1] + arr[i + 2] - dp[i + 3];
            if (i + 1 < n)
                pickTwo = arr[i] + arr[i + 1] - dp[i + 2];
            if (i < n)
                pickOne = arr[i] - dp[i + 1];

            dp[i] = Math.max(pickThree, Math.max(pickTwo, pickOne));

        }
        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}
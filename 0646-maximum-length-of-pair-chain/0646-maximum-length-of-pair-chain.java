class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        // int []prev = new int[n+1];
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });

        // for (int i = 0; i < n + 1; i++) {
        //     if (i == n || pairs[0][1] < pairs[i][0]) {
        //         prev[i] = 1;
        //     }
        // }

        // for (int i = 1; i < n; i++) {
        //     int []curr = new int[n+1];
        //     for (int j = 0; j < n + 1; j++) {
        //         int pick = 0;
        //         if (j == n || pairs[i][1] < pairs[j][0])
        //             pick = 1 + prev[i];
        //         int nopick = prev[j];
        //         curr[j] = Math.max(pick, nopick);
        //     }
        //     prev = curr;
        // }
        int prev = pairs[0][1];
        int ans = 1;
        for(int i=1;i<n;i++){
            if(prev<pairs[i][0]){
                ans++;
                prev = pairs[i][1];
            }
        }
        // return prev[n];

        return ans;
    }
}
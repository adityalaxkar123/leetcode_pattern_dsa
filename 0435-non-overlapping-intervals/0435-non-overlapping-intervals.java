        // this solution is give mle for dp
        // int []prev = new int[n+1];
        // prev[0] = 1;
        // for (int i = 1; i < n + 1; i++) {
        //     if (arr[n - 1][0] >= arr[i - 1][1])
        //         prev[i] = 1;
        // }
        // for (int i = n - 2; i >= 0; i--) {
        //     int []curr = new int[n+1];
        //     curr[0]=0;
        //     for (int j = n; j >= 0; j--) {
        //         int pick = 0;
        //         if (j == 0 || arr[i][0] >= arr[j - 1][1]) {
        //             pick = 1 + prev[i+1];
        //         }
        //         int nopick = prev[j];
        //         curr[j] = Math.max(pick, nopick);
        //     }
        //     prev=curr;
        // }

        // return n - prev[0];
class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> {
            return a[1]-b[1];
        });


        int ans = 1;
        int curr = 1;
        int prevIdx=0;
        for(int i=1;i<n;i++){
            if(arr[i][0]>=arr[prevIdx][1]){
                    curr++;
                    prevIdx=i;
            }
            ans = Math.max(ans,curr);
        }

        return n-ans;
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []prev = new int[n+1];
        if (nums.length == 1)
            return 1;
        for (int i = 0; i < n + 1; i++) {
            if (i == nums.length || nums[0] < nums[i]) {
                prev[i] = 1;
            } else {
                prev[i] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int []curr = new int[n+1];
            for (int j = i+1; j < n + 1; j++) {
                int pick = 0;
                if (j == nums.length || nums[i]<nums[j]) {
                    pick = 1 + prev[i];
                }
                int nopick = prev[j];
                curr[j] = Math.max(pick, nopick);
            }
            prev = curr;
        }
        return prev[n];
    }
}
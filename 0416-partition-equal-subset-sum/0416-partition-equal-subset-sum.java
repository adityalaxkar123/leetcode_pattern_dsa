class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        int n = nums.length;
        if (total % 2 != 0)
            return false;
        int[]prev = new int[total / 2 + 1];
        prev[0] = 1;
        for (int i = 1; i <= total / 2; i++) {
            if (i - nums[0] == 0)
                prev[i] = 1;
            else
                prev[i] = 2;
        }

        for (int i = 1; i < n; i++) {
            int []curr = new int[total/2 + 1];
            for (int j = 1; j <= total / 2; j++) {
                boolean pick = false, nopick = false;
                if (j - nums[i] >= 0)
                    pick = (prev[j - nums[i]]==1)?true:false;
                nopick = (prev[j]==1)?true:false;
                curr[j] = (pick || nopick) ? 1 : 2;
            }
            prev = curr;
        }

        return (prev[total/2]==1)?true:false;
    }
}
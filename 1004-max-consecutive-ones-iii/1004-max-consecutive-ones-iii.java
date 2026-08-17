class Solution {
    public int longestOnes(int[] nums, int k) {
        int expand = 0;
        int shrink = 0;
        int ans = 0;
        int count=k;
        while(expand<nums.length){
            while(shrink<nums.length && count==0 && nums[expand]==0){
                if(nums[shrink]==0)
                    count++;
                shrink++;
            }
            if(nums[expand]==0)
                count--;

            ans = Math.max(ans,expand-shrink+1);
            expand++;
        }

        return ans;
    }
}
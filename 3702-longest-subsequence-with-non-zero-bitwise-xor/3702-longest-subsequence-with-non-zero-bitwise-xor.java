class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = nums[0];
        boolean isAllZero = (nums[0]!=0)?false:true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=0)
                isAllZero=false;
            xor^=nums[i];
        }
        if(isAllZero)
            return 0;
        if(xor!=0)
            return nums.length;
        
        return nums.length-1;
    }
}
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int expand=0,shrink=0,len=1;
        while(expand<nums.length){
            int ele = nums[expand];
            mp.put(ele,mp.getOrDefault(ele,0)+1);
            while(shrink<nums.length && mp.get(ele)>k){
                mp.put(nums[shrink],mp.get(nums[shrink])-1);
                shrink++;
            }
            len=Math.max(len,expand-shrink+1);
            expand++;
        }
        len=Math.max(len,expand-shrink);
    
        return len;
    }
}
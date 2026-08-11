class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        st.add(nums[0]);
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i : nums)
            st.add(i);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                maxSum=Math.max(sum,maxSum);
                break;
            }
            sum+=nums[i];
        }
        maxSum=Math.max(sum,maxSum);
        for(int i=maxSum;i<2501;i++){
            if(!st.contains(i))
                return i;
        }

        return -1;
    }
}
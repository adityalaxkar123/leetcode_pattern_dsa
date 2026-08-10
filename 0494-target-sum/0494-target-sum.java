class Solution {

    public int helper(int []arr,int idx,int sum,int target){
      
        if(idx>=arr.length){
            if(sum==target)
                return 1;
            return 0;
        }

        int plus=0,minus=0;
        plus = helper(arr,idx+1,sum+arr[idx],target);
        minus = helper(arr,idx+1,sum-arr[idx],target);

        return plus+minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        return helper(nums,0,0,target);
    }
}
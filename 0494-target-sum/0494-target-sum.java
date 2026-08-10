class Solution {

    public int helper(int []arr,int idx,int sum){
      
        if(idx>=arr.length){
            if(sum==0)
                return 1;
            return 0;
        }

        int pick=0,nopick=0;
        pick = helper(arr,idx+1,sum-arr[idx]);
        nopick = helper(arr,idx+1,sum);

        return pick+nopick;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total=0;
        for(int i : nums)
            total+=i;
        if((total+target)%2!=0)
            return 0;
        int sum = (total+target)/2;
        return helper(nums,0,sum);
    }
}
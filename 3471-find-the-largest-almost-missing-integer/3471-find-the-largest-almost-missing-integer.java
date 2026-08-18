class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        if(k==nums.length){
            int ans =-1;
            for(var ele : mp.entrySet()){
                ans = Math.max(ans,ele.getKey());
            }
            return ans;
        }
        if(k==1){
            int ans =-1;
            for(var ele : mp.entrySet()){
                if(ele.getValue()==1){
                    ans = Math.max(ans,ele.getKey());
                }
            }
            return ans;
        }
        else{
            int ans = -1;
            int first = -1;
            first = (mp.get(nums[0])>1)?-1:nums[0];
            int second = -1;
            second = (mp.get(nums[nums.length-1])>1)?-1:nums[nums.length-1];
            ans = Math.max(first,second);

            return ans;
        }

    }
}
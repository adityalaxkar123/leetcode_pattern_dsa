class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            HashSet<Integer> st = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int target = -(nums[i]+nums[j]);
                if(st.contains(target)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],target,nums[j])));
                }
                st.add(nums[j]);
            }
        }
        ans.addAll(res);
        return ans;
    }
}
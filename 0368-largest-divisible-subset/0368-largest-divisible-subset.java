class Solution {

    public List<Integer> helper(int[] arr, int idx, int prevIdx,List<Integer>[][] dp) {
        if(idx>=arr.length){
            return new ArrayList<>();
        }
        if(dp[idx][prevIdx]!=null)
            return dp[idx][prevIdx];
        List<Integer> pick = new ArrayList<>();
        if (prevIdx == arr.length || arr[idx] % arr[prevIdx] == 0) {
            pick = new ArrayList<>(helper(arr, idx + 1, idx,dp));
            pick.add(arr[idx]);
        }
        List<Integer> nopick = new ArrayList<>(helper(arr, idx + 1, prevIdx,dp));
        dp[idx][prevIdx] = (pick.size() > nopick.size()) ? pick : nopick;
        return dp[idx][prevIdx];
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer>[][] dp = new ArrayList[n][n+1];
        
        return helper(nums, 0, n,dp);
    }
}
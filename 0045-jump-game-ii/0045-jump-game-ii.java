class Solution {
    public int helper(int []arr,int idx,int []dp){
        if(idx>=arr.length)
            return 100000;
        if(idx==arr.length-1)
            return 0;
        
        if(dp[idx]!=-1)
            return dp[idx];
        
        int j=(arr[idx]!=0)?1:0;
        int pick = 100000;
        while(j<arr.length && j<=arr[idx]){
            if(idx+j!=idx)
                pick = Math.min(pick,1+helper(arr,idx+j,dp));
            j++;
        }

        return dp[idx]=pick;
    }

    public int jump(int[] nums) {
       int n = nums.length;
        if(n==1)
            return 0;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
       return helper(nums,0,dp);
    }
}
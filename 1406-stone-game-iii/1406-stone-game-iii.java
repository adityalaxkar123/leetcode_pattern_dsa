class Solution {
    
    public int helper(int []arr,int st,int []dp){
        int n = arr.length;
        if(st>=n)
            return 0;
        int pickOne=Integer.MIN_VALUE,pickTwo=Integer.MIN_VALUE,pickThree=Integer.MIN_VALUE;
        if(dp[st]!=-1)
            return dp[st];
        if(st+2<n)
            pickThree = arr[st]+arr[st+1]+arr[st+2]-helper(arr,st+3,dp);
        if(st+1<n)
            pickTwo = arr[st]+arr[st+1]-helper(arr,st+2,dp);
        if(st<n)
            pickOne = arr[st]-helper(arr,st+1,dp);
    
        dp[st] = Math.max(pickThree,Math.max(pickTwo,pickOne));
        return dp[st];
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = helper(stoneValue,0,dp);
        if(ans>0)
            return "Alice";
        else if(ans<0)
            return "Bob";
        else
            return "Tie";
    }
}
class Solution {

    public boolean helper(int []arr,int idx,int jump,HashMap<Integer,Integer> mp,Boolean [][]dp){
        if(idx>=arr.length)
            return false;
        if(idx==arr.length-1)
            return true;
        if(dp[idx][jump]!=null)
            return dp[idx][jump];
        
        boolean pick = false;
        if(idx==0){
            if(mp.get(arr[idx]+jump)!=null)
                pick = helper(arr,mp.get(arr[idx]+jump),jump,mp,dp);
        }
        else{
            int []canJump = {jump-1,jump,jump+1};
            for(int x : canJump){
                if(x<=0)
                    continue;
                if(mp.get(arr[idx]+x)!=null){
                    pick = helper(arr,mp.get(arr[idx]+x),x,mp,dp);
                }
                if(pick)
                    break;
            }
        }

        return dp[idx][jump]=pick;
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)
            mp.put(stones[i], i);
        
        Boolean [][]dp = new Boolean[n][n+1];
        return helper(stones, 0, 1, mp,dp);
    }
}
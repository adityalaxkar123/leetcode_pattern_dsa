class Solution {

    public boolean helper(int n,int turn,int [][]dp){
        if(n==0 && turn==0){
            dp[n][turn]=2;
            return false;
        }
        if(n==0 && turn==1){
            dp[n][turn]=1;
            return true;
        }
        if(dp[n][turn]!=0)
            return dp[n][turn]==1?true:false;
        int ans = (int)Math.sqrt(n);
        boolean pick = false;
        if(turn==0){
            for(int i=1;i<=ans;i++){
                pick = helper(n-i*i,1,dp);
                if(pick)
                    break;
            }
        }
        else{
            for(int i=1;i<=ans;i++){
                pick = helper(n-i*i,0,dp);
                if(!pick)
                    break;
            }
        }
        dp[n][turn]=(pick)?1:2;
        return dp[n][turn]==1?true:false;
    }

    public boolean winnerSquareGame(int n) {
        int [][]dp = new int[n+1][2];
        return helper(n,0,dp);
    }
}
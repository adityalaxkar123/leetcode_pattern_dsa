class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prevMin = cost[0];
        int currMin = cost[1];
        for(int i=2;i<cost.length;i++){
            int temp = prevMin;
            prevMin = currMin;
            currMin = cost[i]+Math.min(temp,currMin);
        }

        return Math.min(currMin,prevMin);
    }
}
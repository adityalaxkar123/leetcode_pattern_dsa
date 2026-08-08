class Solution {
    public int helper(int []arr,int i,int curr){
        if(i<0)
            return 0;
        if(arr[i]<curr){
            return Math.max(curr-arr[i],helper(arr,i-1,curr));
        }
        else{
            return helper(arr,i-1,arr[i]);
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        return helper(prices,n-1,-1);
    }
}
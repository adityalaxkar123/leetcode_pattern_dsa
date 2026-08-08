class Solution {

    public int helper(int []arr,int i,int curr){
        if(i<0)
            return 0;
        if(arr[i]<curr)
            return curr-arr[i]+helper(arr,i-1,arr[i]);
        else
            return helper(arr,i-1,arr[i]);
    }

    public int maxProfit(int[] arr) {
        int n = arr.length;

        return helper(arr,n-1,-1);
    }
}
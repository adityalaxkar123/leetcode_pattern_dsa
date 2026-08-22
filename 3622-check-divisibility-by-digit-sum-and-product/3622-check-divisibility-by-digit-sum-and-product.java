class Solution {
    public boolean checkDivisibility(int n) {
        int first = 0;
        int second = 1;
        int original = n;
        while(n>0){
            int curr = n%10;
            first = first + curr;
            second = second * curr;
            n/=10;
        }
        int dividend = first+second;
        if(original%dividend==0)
            return true;
        
        return false;
    }
}
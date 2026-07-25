class Solution {
    public int maxProduct(int n) {
        int []freq = new int[10];
        while(n>0){
            int currDigit = n%10;
            freq[currDigit]++;
            n/=10;
        }
        int ans = 1;
        int count=0;
        for(int i = 9;i>=0;i--){
            if(count==2)
                break;
            if(freq[i]>=2 && count==0){
                ans=i*i;
                break;
            }
            if(freq[i]>0){
                ans*=i;
                count++;
            }
        }
        return ans;
    }
}
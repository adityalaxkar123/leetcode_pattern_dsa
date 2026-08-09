class Solution {
    public boolean isMatch(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // int [][]dp = new int[n+1][m+1];
        int []prev = new int[m+1];
        prev[0]=1;
        for(int j=1;j<m+1;j++){
            int k = j;
            boolean ans = true;
            while(k>0){
                if(s2.charAt(k-1)!='*'){
                    ans=false;
                    break;
                }
                k--;
            }
            if(ans)
                prev[j]=1;
            else
                prev[j]=2;
        }

        for(int i=1;i<n+1;i++){
            int []curr = new int[m+1];
            curr[0]=2;
            for(int j=1;j<m+1;j++){
                int match = 2,notMatch=2;
                curr[j]=2;
                if(s1.charAt(i-1)==s2.charAt(j-1) || s2.charAt(j-1)=='?')
                    match = prev[j-1];
                else if(s2.charAt(j-1)=='*')
                    notMatch = (prev[j]==1 || curr[j-1]==1)?1:2;
                curr[j] = (match==1 || notMatch==1)?1:2;
            }
            prev = curr;
        }
       
       return prev[m]==1?true:false;
    }
}
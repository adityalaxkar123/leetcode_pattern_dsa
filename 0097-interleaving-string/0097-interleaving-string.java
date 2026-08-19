class Solution {

    public boolean helper(String s1, String s2, String s3,int i,int j){
        if(i<0 && j<0)
            return true;
        boolean pick = false;
        if(i>=0 && s1.charAt(i)==s3.charAt(i+j+1) && j>=0 && s2.charAt(j)==s3.charAt(i+j+1)){
            pick = helper(s1,s2,s3,i-1,j) || helper(s1,s2,s3,i,j-1);
        }else if(i>=0 && s1.charAt(i)==s3.charAt(i+j+1)){
            pick = helper(s1,s2,s3,i-1,j);
        }else if(j>=0 && s2.charAt(j)==s3.charAt(i+j+1)){
            pick = helper(s1,s2,s3,i,j-1);
        }else{
            return false;
        }

        return pick;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if(k!=n+m)
            return false;
        return helper(s1,s2,s3,n-1,m-1); 
    }
}
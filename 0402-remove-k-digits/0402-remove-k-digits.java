class Solution {
    public String removeKdigits(String num, int k) {
        int count  = k;
        int i = 1;
        int n = num.length();
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));
        while(i<n){
            char a = num.charAt(i);
            while(sb.length() > 0 && count>0 && a<sb.charAt(sb.length()-1)){
                sb.deleteCharAt(sb.length()-1);
                count--;
            }
            sb.append(a);
            i++;
        }
        while(count>0){
            sb.deleteCharAt(sb.length()-1);
            count--;
        }

        i=0;
        while(i<sb.length() && sb.charAt(i)=='0'){
            i++;
        }
        String ans = sb.substring(i);
    
        return (ans.length()==0)?"0":ans;    
    }
}
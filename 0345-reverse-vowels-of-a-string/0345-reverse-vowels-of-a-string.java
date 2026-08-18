class Solution {
    public boolean isVowel(char a){
        return a=='a' || a=='e'||a=='i'||a=='o'||a=='u'||a=='A'||a=='E'||a=='I'||a=='O'||a=='U';
    }
    
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int st =0,end=sb.length()-1;
        while(st<=end){
            if(isVowel(sb.charAt(st)) && isVowel(sb.charAt(end))){
                char temp = sb.charAt(st);
                sb.setCharAt(st,sb.charAt(end));
                sb.setCharAt(end,temp);
                st++;
                end--;
                continue;
            }
            if(isVowel(sb.charAt(st))){
                end--;
            }
            else if(isVowel(sb.charAt(end))){
                st++;
            }else{
                st++;
                end--;
            }
        }

        return sb.toString();
    }
}
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        int close = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push('(');
            else{
                if(st.isEmpty())
                    close++;
                else
                    st.pop();
            }
        }
        return st.size()+close;
    }
}
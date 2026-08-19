class Solution {

    public void helper(String s,int idx,HashSet<String> st,List<String> ans,List<String> curr){
        if(idx>=s.length()){
            String k = String.join(" ",curr);
            ans.add(k);
            return;
        }
        int j;
        StringBuilder sb = new StringBuilder();
        for(j=idx;j<s.length();j++){
            sb.append(s.charAt(j));
            if(st.contains(sb.toString())){
                curr.add(sb.toString());
                helper(s,j+1,st,ans,curr);
                curr.remove(curr.size()-1);
            }

        }

        
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> st = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            st.add(wordDict.get(i));
        }
        List<String> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(s,0,st,ans,curr);
        return ans;
    }
}
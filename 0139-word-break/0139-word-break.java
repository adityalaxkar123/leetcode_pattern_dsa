class Solution {

    public boolean helper(String s, int idx, HashSet<String> st,Boolean []dp) {
        if(idx>=s.length())
            return true;
        int j;
        if(dp[idx]!=null)
            return dp[idx];
        StringBuilder sb = new StringBuilder();
        boolean pick = false;
        for(j=idx;j<s.length();j++){
            sb.append(s.charAt(j));
            if(st.contains(sb.toString())){
                pick = helper(s,j+1,st,dp);
            }
            if(pick)
                break;
        }

        return dp[idx]=pick;

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>();
        for (String k : wordDict)
            st.add(k);
        int n = s.length();
        Boolean []dp = new Boolean[n];
        return helper(s,0,st,dp);
    }
}
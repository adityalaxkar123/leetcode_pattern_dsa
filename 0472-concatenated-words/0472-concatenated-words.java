class Solution {

    public boolean helper(String s,int idx,HashSet<String> st,Boolean []dp){
        if(idx>=s.length())
            return true;
        if(dp[idx]!=null)
            return dp[idx];
        int j = idx;
        boolean pick = false;
        while(j<s.length()){
            if(st.contains(s.substring(idx,j+1))){
                pick = helper(s,j+1,st,dp);
            }
            if(pick)
                break;
            j++;
        }

        return dp[idx]=pick;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words,(a,b)->{
            return Integer.compare(a.length(),b.length());
        });
        HashSet<String> st = new HashSet<>();
        int n = words.length;
        st.add(words[0]);
        List<String> ans = new ArrayList<>();
        for(int i=1;i<n;i++){
            Boolean []dp = new Boolean[words[i].length()];
            if(helper(words[i],0,st,dp)){
                ans.add(words[i]);
            }
            st.add(words[i]);
            
        }

        return ans;
    }
}
class Solution {

    public boolean helper(String s,int idx,HashSet<String> st){
        if(idx>=s.length())
            return true;
        
        int j = idx;
        StringBuilder sb = new StringBuilder();
        boolean pick = false;
        while(j<s.length()){
            sb.append(s.charAt(j));
            if(st.contains(sb.toString())){
                pick = helper(s,j+1,st);
            }
            if(pick)
                break;
            j++;
        }

        return pick;
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
            if(helper(words[i],0,st)){
                ans.add(words[i]);
            }else{
                st.add(words[i]);
            }
            
        }

        return ans;
    }
}
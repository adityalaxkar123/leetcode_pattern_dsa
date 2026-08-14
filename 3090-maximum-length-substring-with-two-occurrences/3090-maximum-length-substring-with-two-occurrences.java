class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int expand=0,shrink=0,ans = 1;
        HashMap<Character,Integer> mp = new HashMap<>();
        while(expand<n){
            char c = s.charAt(expand);
            mp.put(c,mp.getOrDefault(c,0)+1);
            while(shrink<n && mp.get(c)>2){
                char k = s.charAt(shrink);
                mp.put(k,mp.get(k)-1);
                shrink++;
            }
            ans=Math.max(ans,expand-shrink+1);
            expand++;
        }
        ans=Math.max(ans,expand-shrink);

        return ans;
    }
}
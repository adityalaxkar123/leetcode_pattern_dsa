class Solution {

    public List<String> generate(String s, HashSet<String> b, HashSet<String> isVisited) {
        StringBuilder st = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] arr = { 'A', 'C', 'G', 'T' };
            for (char a : arr) {
                char original = st.charAt(i);
                st.setCharAt(i, a);
                if (b.contains(st.toString()) && !isVisited.contains(st.toString())) {
                    ans.add(st.toString());
                }
                st.setCharAt(i,original);
            }
        }
        return ans;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<>();
        int len = 0;
        HashSet<String> b = new HashSet<>();
        HashSet<String> isVisited = new HashSet<>();
        for (String s : bank)
            b.add(s);
        q.add(startGene);
        isVisited.add(startGene);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.remove();
                if(s.equals(endGene)){
                    return len;
                }
                List<String> ans = generate(s,b,isVisited);
                for(String k : ans){
                    q.add(k);
                    isVisited.add(k);
                }
            }
            len++;
        }

        return -1;
    }
}
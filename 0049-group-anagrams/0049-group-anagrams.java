class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        HashMap<String,ArrayList<String>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            char []arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);
            if(mp.get(st)==null)
                mp.put(st,new ArrayList<>(Arrays.asList(strs[i])));
            else
                mp.get(st).add(strs[i]);
        }

        for(var ele : mp.entrySet()){
            ans.add(ele.getValue());
        }

        return ans;
    }
}
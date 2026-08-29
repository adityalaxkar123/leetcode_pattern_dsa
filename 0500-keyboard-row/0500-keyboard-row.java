class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> first = new HashSet<>();
        HashSet<Character> second = new HashSet<>();
        HashSet<Character> third = new HashSet<>();
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            first.add(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++){
            second.add(s2.charAt(i));
        }
        for(int i=0;i<s3.length();i++){
            third.add(s3.charAt(i));
        }

        for(String k : words){
            String s = k.toLowerCase();
            boolean isValid1 = true;
            boolean isValid2 = true;
            boolean isValid3 = true;
            for(int i=0;i<s.length();i++){
                if(!first.contains(s.charAt(i))){
                    isValid1=false;
                    break;
                }
            }
            for(int i=0;i<s.length();i++){
                if(!second.contains(s.charAt(i))){
                    isValid2=false;
                    break;
                }
            }
            for(int i=0;i<s.length();i++){
                if(!third.contains(s.charAt(i))){
                    isValid3=false;
                    break;
                }
            }
            if(isValid1 || isValid2 || isValid3)
                ans.add(k);
        }

        String []res = new String[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i]=ans.get(i);

        return res;
    }
}
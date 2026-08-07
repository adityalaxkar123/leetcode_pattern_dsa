class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int []prev = new int[m];
        if (s1.charAt(0) == s2.charAt(0))
            prev[0] = 1;

        for(int i=1;i<m;i++){
            if (s1.charAt(0) == s2.charAt(i))
                prev[i] = 1;
            else
                prev[i]=prev[i-1];
        }

        for (int i = 1; i < n; i++) {
            int []curr = new int[m];
            curr[0]=prev[0];
            if (s1.charAt(i) == s2.charAt(0))
                curr[0] = 1;
            for (int j = 1; j < m; j++) {
                int pick = 0;
                if (s1.charAt(i) == s2.charAt(j))
                    pick = 1 + prev[j-1];
                int np1 = prev[j];
                int np2 = curr[j-1];
                curr[j] = Math.max(pick, Math.max(np1, np2));
            }
            prev=curr;
        }

        return n + m - 2 * prev[m-1];
    }
}
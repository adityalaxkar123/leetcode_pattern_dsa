class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int []prev = new int[m+1];
        prev[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int []curr = new int[m+1];
            curr[0]=1;
            for (int j = 1; j < m + 1; j++) {
                int pick = 0;
                if (s.charAt(i-1) == t.charAt(j-1))
                    pick = prev[j-1];
                int nopick = prev[j];
                curr[j] = pick + nopick;
            }
            prev = curr;
        }

        return prev[m];
    }
}
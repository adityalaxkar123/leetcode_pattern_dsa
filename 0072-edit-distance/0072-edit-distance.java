class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int []prev = new int[m+1];
        for (int j = 0; j < m + 1; j++) {
            prev[j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            int []curr = new int[m+1];
            curr[0]=i;
            for (int j = 1; j < m + 1; j++) {
                int insert = Integer.MAX_VALUE, replace = Integer.MAX_VALUE, remove = Integer.MAX_VALUE,
                        equal = Integer.MAX_VALUE;
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    equal = 0 + prev[j-1];
                } else {
                    replace = 1 + prev[j-1];
                    remove = 1 + prev[j];
                    insert = 1 + curr[j-1];
                }
                curr[j] = Math.min(equal, Math.min(replace, Math.min(remove, insert)));
            }
            prev = curr;
        }

        return prev[m];
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextS = new int[n];
        int[] prevS = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        nextS[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()){
                nextS[i] = -1;
            }
            else{
                nextS[i] = st.peek();
            }
            st.push(i);   
        }
        prevS[0]=-1;
        st.clear();
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()){
                prevS[i] = -1;
            }
            else{
                prevS[i] = st.peek();
            }
            st.push(i);   
        }

        int i = 0;
        int ans = 0;
        while (i < n) {
            int width = ((nextS[i]!=-1)?nextS[i]:n)-prevS[i]-1;
            ans = Math.max(ans,heights[i]*width);

            i++;
        }

        return ans;
    }
}
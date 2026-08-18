class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int []leftMax = new int[n];
        int []rightMax = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(height[n-1]);
        rightMax[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightMax[i]=-1;
                st.push(height[i]);   
            }else{
                rightMax[i]=st.peek();
            }
 
        }

        st.clear();
        leftMax[0]=-1;
        st.push(height[0]);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && st.peek()<=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftMax[i]=-1;
                st.push(height[i]);
            }else{
                leftMax[i]=st.peek();
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(leftMax[i]!=-1 && rightMax[i]!=-1)
                ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }
}
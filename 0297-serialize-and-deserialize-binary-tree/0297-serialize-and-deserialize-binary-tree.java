/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) 
            return "N";
        StringBuilder st = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        st.append('(').append(root.val).append(')');
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = q.remove();
                if(curr.left==null)
                    st.append('N');
                if(curr.left!=null){
                    st.append('(').append(curr.left.val).append(')');
                    q.add(curr.left);
                }
                if(curr.right==null)
                    st.append('N');
                if(curr.right!=null){
                    st.append('(').append(curr.right.val).append(')');
                    q.add(curr.right);
                }
                
            }
        }

        return st.toString();
    }
    public int solve(String s,int []idx){
        int start = idx[0];
        int i = start+1;
        while(s.charAt(i)!=')'){
            i++;
        }
        idx[0]=i+1;
        return Integer.parseInt(s.substring(start+1,i));
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.charAt(0)=='N')
            return null;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        int count = 1;
        int []idx = new int[1];
        idx[0]=0;
        TreeNode root = new TreeNode(solve(data,idx));
        q1.add(root);
        while(!q1.isEmpty()){
            int currCount = 0;
            int n = count*2;
            while(n>0){
                if(data.charAt(idx[0])=='N'){
                    q2.add(null);
                    idx[0]++;
                }
                else{
                    q2.add(new TreeNode(solve(data,idx)));
                    currCount++;
                }
                n--;
            }
            int size = q1.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q1.remove();
                TreeNode left = q2.remove();
                TreeNode right = q2.remove();
                curr.left = left;
                curr.right = right;
                if(left!=null)  q1.add(left);
                if(right!=null) q1.add(right);
            }
            count=currCount;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
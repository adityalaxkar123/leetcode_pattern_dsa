class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(nums1[a[0]]+nums2[a[1]],nums1[b[0]]+nums2[b[1]]);
        });
        int n = nums1.length,m=nums2.length;
        int i=0,j=0;
        for(i=0;i<n;i++){
            pq.add(new int[]{i,0});
        }

        List<List<Integer>> ans = new ArrayList<>();
        while(k>0 && !pq.isEmpty()){
            int []cur = pq.remove();
            i = cur[0];
            j = cur[1];

            ans.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])));
            if(j+1<m){
                pq.add(new int[]{i,j+1});
            }
            k--;
        }

        return ans;
    }
}
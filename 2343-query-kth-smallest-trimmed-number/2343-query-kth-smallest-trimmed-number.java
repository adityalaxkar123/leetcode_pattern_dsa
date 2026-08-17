class Pair{
    String ele;
    int idx;
    Pair(String ele,int idx){
        this.ele=ele;
        this.idx=idx;
    }
}

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int []ans = new int[m];
        for(int i=0;i<m;i++){
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
                if(b.ele.compareTo(a.ele)!=0){
                    return b.ele.compareTo(a.ele);
                }
                return Integer.compare(b.idx,a.idx);

            });
            for(int j=0;j<n;j++){
                int p = nums[j].length();
                String ele = nums[j].substring(p-queries[i][1],p);
                pq.add(new Pair(ele,j));
                if(pq.size()>queries[i][0])
                    pq.remove();
            }
            ans[i]=pq.remove().idx;
        }


        return ans;
    }
}
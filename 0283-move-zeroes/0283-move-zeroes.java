class Solution {
    public void moveZeroes(int[] nums) {
        int placed = 0;
        int i=0;
        while(i<nums.length-placed){
            if(nums[i]==0){
                for(int j=i+1;j<nums.length-placed;j++){
                    int temp = nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                }
                placed++;
                continue;
            }
            i++;
        }
    }
}
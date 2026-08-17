class Solution {
    public void moveZeroes(int[] arr) {
        int ptr1=0;
        int ptr2=0;
        while(ptr2<arr.length && ptr1<arr.length){
            if(arr[ptr1]!=0){
                ptr1++;
                continue;
            }
            if(arr[ptr2]==0){
                ptr2++;
                continue;
            }
            if(ptr2>=ptr1){
                int temp = arr[ptr1];
                arr[ptr1]=arr[ptr2];
                arr[ptr2]=temp;
            }
            ptr2++;
        }
    }
}
package sort.seventy_five;

// quick sort
public class Solution {

    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        int [] nums2 = {3,2,3,1,2,4,5,5,6};
        int [] nums3 = {0,2,0};

//        new Solution().partition(nums2,0,nums2.length-1);
//        for(int i:nums2)
//            System.out.print(i+",");
        new Solution().sortColors(nums3);
        System.out.println();
        for(int i:nums3)
           System.out.print(i+",");
    }

    // rules: in-place sorting
    public void sortColors(int[] nums) {
        partition(nums,0,nums.length-1);
    }

    public void partition(int[] nums,int left, int right){
        //System.out.println("left: "+left+" ,right: "+right);
        int pivot = left;
        int index = pivot+1;
        for(int i = index;i<=right;i++){
            if(nums[i]<nums[pivot])
                swap(nums,i,index++);
        }
        int p = index-1;
        swap(nums,p,pivot);
        if(p-1>left)
            partition(nums,left,p-1);
        if(p+1<right)
            partition(nums,p+1,right);
    }

    public void swap(int [] nums,int x,int y){
        int temp = nums [x];
        nums [x] = nums [y];
        nums [y] = temp;
    }
}

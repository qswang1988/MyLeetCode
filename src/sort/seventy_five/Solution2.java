package sort.seventy_five;

public class Solution2 {
    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        int [] nums2 = {3,2,3,1,2,4,5,5,6};
        int [] nums3 = {0,2,0};

        new Solution2().sortColors(nums3);
        for(int i:nums3)
            System.out.print(i+",");
    }

    public void sortColors(int[] nums) {
        int pointer = 0;
        for(int i = 0;i<2;i++){
            for(int j = pointer;j<nums.length;j++){
                if(nums[j]==i)
                    swap(nums,j,pointer++);
            }
        }
    }

    public void swap(int [] nums,int x,int y){
        int temp = nums [x];
        nums [x] = nums [y];
        nums [y] = temp;
    }
}

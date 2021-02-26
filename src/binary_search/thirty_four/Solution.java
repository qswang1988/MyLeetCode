package binary_search.thirty_four;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int [] nums2 = {3,4};
        int [] nums3 = {0,0,2,3,4,4,4,5};
        int [] r = new Solution().searchRange(nums3,1);
        Arrays.stream(r).forEach(System.out::println);
    }

    public int[] searchRange(int[] nums, int target) {

        int size = nums.length;
        if(size == 0||target>nums[nums.length-1]||target<nums[0])
            return new int [] {-1,-1};

        int left = 0;
        int right = size-1;
        int pos = -1;
        while(left<=right){
            int half = (left+right)/2;
            int num_half = nums[half];
            //System.out.println("left: "+left+" ,right: "+right+" half: "+half+" ,halfnum: "+num_half);

            if(left==right-1&&nums[left]<target&&nums[right]>target)
                break;

            if(num_half>target){
                right = half;
            }else if(num_half<target){
                if(left == half)
                    left++;
                else
                    left = half;
            }else{
                pos = half;
                break;
            }

        }
        //System.out.println("pos: "+pos);
        if(pos==-1)
            return new int [] {-1,-1};

        left = pos;
        right = pos;
        while(left>=0&&nums [left] == target)
            left--;
        while(right<nums.length&&nums [right] == target)
            right++;

        return new int [] {++left,--right};
    }
}

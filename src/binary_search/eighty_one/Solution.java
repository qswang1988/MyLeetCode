package binary_search.eighty_one;

public class Solution {

    public static void main(String[] args) {
        int [] nums = {2,5,6,0,0,1,1};
        int [] nums2 = {1};
        int [] nums3 = {1,0,1,1,1};
        int [] nums4 = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int [] nums5 = {2,2,2,3,2,2,2};
        int [] nums6 = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};

        boolean r = new Solution().search(nums6,13);
        System.out.println(r);
    }

    public boolean search(int[] nums, int target) {

        if (nums.length == 0)
            return false;
        if (nums.length == 1)
            return (nums[0] == target);

        int left = 0;
        int right = nums.length - 1;
        int pos = 0;
        while (left <= right) {
            if (nums[left] == target || nums[right] == target)
                return true;
            if (nums[++left] < nums[left - 1]) {
                pos = left - 1;
                break;
            }
            if (nums[--right] > nums[right + 1]) {
                pos = right;
                break;
            }
        }

        // nums[pos] now is the largest number in array,
        left = 0;
        right = nums.length - 1;
        if (nums[pos] >= target && nums [0]<=target)
            right = pos;
        else
            left = pos + 1;

        while (left < right - 1) {
            //System.out.println("left: " + left + ", right: " + right + " ,half: " + half);
            int half = (left + right) / 2;
            int nums_half = nums[half];
            if (nums_half == target)
                return true;
            else if(nums_half>target)
                right = half;
            else
                left = half;
        }
        return nums[left]==target||nums[right]==target;
    }
}

package binary_search.one_fiftyfour;

public class Solution {

    public static void main(String[] args) {
        int [] nums = {2,2,2,0,1};
        int [] nums2 = {1,3,5};
                        // 5,1,3
        int [] nums3 = {4,5,6,7,0,1,4};
        int [] nums4 = {1};
        int [] nums5 = {3,3,1,3};
        int [] nums6 = {1,1,1};
        int [] nums7 = {1,1,3,1};
        int r = new Solution().findMin(nums7);
        System.out.println(r);

    }

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            //System.out.println("left/right: "+left+"/"+right );
            if(left==right-1||left==right)
                return Integer.min(nums[left],nums[right]);

            int mid = (left+right)/2;
            //System.out.println("mid: "+mid);
            /*if(nums[left]>nums[mid]){
                right = mid;
                continue;
            }else */
            if(nums[right]<nums[mid]) {
                left = mid;
                continue;
            }else if(nums[left]==nums[mid]&&nums[right]==nums[mid]){
                int low = left;
                int high = right;
                while(low<high){
                    if(nums[low]>nums[low+1])
                        return nums[low+1];
                    if(nums[high]<nums[high-1])
                        return nums [high];
                    low++;
                    high--;
                }
                return nums[low-1];
            }else // "as same as the original order" or "nums[left]>nums[mid]"
                right = mid;
        }

        return 0;
    }

}

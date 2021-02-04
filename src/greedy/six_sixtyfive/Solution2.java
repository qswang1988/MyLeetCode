package greedy.six_sixtyfive;

public class Solution2 {

    public static void main(String[] args) {
        int [] nums1 = {4,2,1};
        int [] nums2 = {4,2,3};
        int [] nums3 = {3,4,2,3};
        int [] nums4 = {5,7,1,8};
        int [] nums5 = {-1,4,2,3};
        // nums[i] <= nums[i + 1]
        boolean r = new Solution2().checkPossibility(nums5);
        System.out.println(r);
    }

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return true;
        }

        if (nums == null || nums.length <= 1) {
            return true;
        }
        int cnt = 0;
        for (int i = 1; i < len && cnt < 2; i++) {
            if (nums[i-1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i-2>=0 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            }else { // 可以省略
                nums[i-1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}

package greedy.six_sixtyfive;

public class Solution {

    public static void main(String[] args) {
        int [] nums1 = {4,2,1};
        int [] nums2 = {4,2,3};
        int [] nums3 = {3,4,2,3};
        int [] nums4 = {5,7,1,8};
        int [] nums5 = {-1,4,2,3};
        // nums[i] <= nums[i + 1]
        boolean r = new Solution().checkPossibility(nums1);
        System.out.println(r);
    }

    // 这个解法效率很低。
    // 逻辑是 每次抽掉一个数，看剩下的数是否是从小到大排序。只要有一个能成功，就说明这个数列是一个只
    // 修改一次就可以成为 NON-DECREASING 数列
    public boolean checkPossibility(int[] nums) {
        if(nums.length == 1)
            return true;
        //int count = 0;
        //int jump = 0;
        //int continues_descend = 0;
        for (int i = 0; i < nums.length; i++) {
            int last = -100000;
            int count = 0;
            for(int j = 0;j<nums.length;j++){
                if(j == i)
                    continue;
                //System.out.print(nums [j]+ " ");
                if(nums[j]<last){
                    count++;
                    break; // 可以 BREAK 了，因为再继续完成这一轮的循环没意义
                }
                last = nums [j];
            }
            if(count == 0)
                return true;
        }
        //System.out.println();
        //System.out.println(count);
        return false;
    }
}

package binary_search.four;

public class Solution2 {
    public static void main(String[] args) {
        int [] nums2 = {2,3,4};
        int [] nums1 = {1};
        double r = new Solution2().findMedianSortedArrays(nums1,nums2);
        System.out.println(r);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int target_left_elements = (nums1.length+nums2.length)/2;
        int current_left_ele = 0;
        int nums1_pointer = 0;
        int nums2_pointer = 0;
        int last_put_element = 0;
        //System.out.println("target_left_element: "+target_left_elements);



        return 0.0;
    }

}

package binary_search.four;

// it is too hard for me to deal with the boundary problem of 2 arrays. This solution is inspired by 2 solutions on internet. I merged them and make them easier to understand.
// the performance doesn't get better than my own solution 1 based on given test cases.
public class Solution2 {
    public static void main(String[] args) {
        int [] nums1 = {5,5,6,7};
        int [] nums2 = {2,3,4,5};
        int [] nums3 = {1,3,4,9};
        int [] nums4 = {5,6,7,8,9,10,11,12,13,15,18};
        int [] nums5 = {1,3};
        int [] nums6 = {2};
        double r = new Solution2().findMedianSortedArrays(nums5,nums6);
        System.out.println(r);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int target_left_elements = (nums1.length+nums2.length+1)/2;
        //System.out.println("target_elements_on_left_side: "+target_left_elements);
        boolean odd_elements = (nums1.length+nums2.length)%2 == 1;
        if(nums1.length>nums2.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int nums1_left = 0;
        int nums1_right = nums1.length;
        int nums1_mid = 0;
        int nums2_mid = 0;
        int nums1L,nums1R,nums2L,nums2R;
        while(nums1_left<=nums1_right){

            nums1_mid = nums1_left+(nums1_right-nums1_left+1)/2;
            nums2_mid = target_left_elements - nums1_mid;

            //System.out.println("nums1_mid: "+nums1_mid);
            //System.out.println("nums2_mid: "+nums2_mid);
            //nums1_mid, nums2_mid :elements on the right side of boundary;
            // mid - 1 : elements on the left side of boundary

            nums1L = nums1_mid == 0?Integer.MIN_VALUE:nums1[nums1_mid-1];
            nums1R = nums1_mid==nums1.length?Integer.MAX_VALUE:nums1[nums1_mid];
            nums2L = nums2_mid==0? Integer.MIN_VALUE:nums2[nums2_mid-1];
            nums2R = nums2_mid==nums2.length?Integer.MAX_VALUE:nums2[nums2_mid];

            if(nums1L<=nums2R&&nums2L<=nums1R){
                if(odd_elements)
                    return Integer.max(nums1L,nums2L);
                else{
                    int sum = Integer.min(nums1R,nums2R)+Integer.max(nums1L,nums2L);
                    return (double)sum/2;
                }
            }else if(nums1L>nums2R){
                nums1_right = nums1_mid - 1;
            }else{
                nums1_left = nums1_mid;
            }

        }

        return 0.0;
    }

}

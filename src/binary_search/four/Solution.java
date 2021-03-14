package binary_search.four;

// not O(log(m+n))
// double pointer solution
// it's O((m+n)/2), but still beat 99.8%
// I will try O(log(m+n)) in solution2
public class Solution {

    public static void main(String[] args) {
        int [] nums2 = {2,3,4};
        int [] nums1 = {1};
        double r = new Solution().findMedianSortedArrays(nums1,nums2);
        System.out.println(r);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int target_left_elements = (nums1.length+nums2.length)/2;
        int current_left_elements = 0;
        int nums1_pointer = 0;
        int nums2_pointer = 0;
        int last_put_element = 0;
        //System.out.println("target_left_element: "+target_left_elements);
        while(current_left_elements<target_left_elements){
            //System.out.println("current_left_element: "+current_left_ele);
            if(nums2_pointer<nums2.length&&nums1_pointer<nums1.length){
                if(nums1[nums1_pointer]<=nums2[nums2_pointer])
                    last_put_element = nums1 [nums1_pointer++];
                else
                    last_put_element = nums2 [nums2_pointer++];
            }else if(nums2_pointer<nums2.length)
                last_put_element = nums2 [nums2_pointer++];
            else
                last_put_element = nums1 [nums1_pointer++];

            current_left_elements++;
        }
        //System.out.println("out of loop, current_left_element: "+current_left_ele);
        //System.out.println("nums1_pointer: "+nums1_pointer+", nums2_pointer: "+nums2_pointer);

        int med;
        if(nums1_pointer>=nums1.length)
            med = nums2[nums2_pointer];
        else if(nums2_pointer>=nums2.length)
            med = nums1[nums1_pointer];
        else
            med = Integer.min(nums1[nums1_pointer],nums2[nums2_pointer]);

        return (nums1.length+nums2.length)%2==1?med:(double)(med+last_put_element)/2;
    }

}

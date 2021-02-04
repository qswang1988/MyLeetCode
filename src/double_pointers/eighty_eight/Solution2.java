package double_pointers.eighty_eight;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        int [] n1 = {1,2,3,0,0,0};
        int m = 3;
        int [] n2 = {2,5,6};
        int n = 3;
        int [] n3 = {2,0};
        int [] n4 = {1};

        int [] n5 = {4,5,6,0,0,0};
        int [] n6 = {1,2,3};

        int [] n7 = {0,0,3,0,0,0,0,0,0};
        int [] n8 = {-1,1,1,1,2,3};

        int [] n9 = {-1,0,0,0,3,0,0,0,0,0,0};
        int [] n10 = {-1,-1,0,0,1,2};

        int [] n11 = {-10,-10,-10,-10,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-4,-4,-4,-4,-3,-3,-3,-2,-2,-1,-1,-1,0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3,4,5,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] n12 = {-10,-10,-10,-10,-10,-10,-9,-9,-9,-8,-8,-8,-8,-7,-7,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-4,-4,-4,-3,-3,-3,-3,-2,-2,-2,-2,-2,-2,-1,-1,0,1,1,1,2,2,2,2,2,2,2,2,2,3,3,4,4,4,5,5,5,5,6,6,6,6,6,6,6,7,8,8,8,9,9,9,9,9};

        new Solution2().merge(n3,1,n4,1);
        Arrays.stream(n3).forEach(x-> System.out.print(x+" "));
        System.out.println();
    }


    // compare from the end to the start.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }else if(m == 0){
            System.arraycopy(nums2,0,nums1,0,nums2.length);
            return;
        }

        int i = m-1, j = n-1, l= m+n-1;

        while (j>=0) {

            if(nums2[j]>nums1[i])
                nums1[l--] = nums2[j--];
            else{
                nums1[l--] = nums1 [i];
                if(i == 0)
                    nums1 [0] = nums2 [j--];
                else
                    i--;
            }


        }
    }

}

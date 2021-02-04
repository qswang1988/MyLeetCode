package double_pointers.eighty_eight;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int [] n1 = {1,2,3,0,0,0};
        int m = 3;
        int [] n2 = {2,5,6};
        int n = 3;
        new Solution().merge(n1,m,n2,n);
        Arrays.stream(n1).forEach(x-> System.out.print(x+" "));
        System.out.println();
    }

    // compare from the start to the end
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //System.arraycopy();
        int i = 0,j = 0;
        while(j<n){
            if(nums2[j]<=nums1[i]){
                for(int k = nums1.length-1;k>i;k-- ){
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }else if(i<m){
                i++;
            }else{
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }
            /*
            if(nums2[j]>nums1[i]){
                if(i<m){
                    i++;
                    continue;
                }else{
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                    m++;
                }
            }else{ // <=
                for(int k = nums1.length-1;k>i;k-- ){
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }
             */
        }
    }
}

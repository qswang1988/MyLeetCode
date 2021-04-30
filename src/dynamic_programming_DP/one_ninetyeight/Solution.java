package dynamic_programming_DP.one_ninetyeight;

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int [] nums2 = {2,7,9,3,1};
        int r = new Solution().rob(nums2);
        System.out.println(r);
    }


    /*
    *
    *       from 1,2,3....N
    *
    *       2       the_max = 2, second_max = 0
    *       2,7 -> 7  7>2   the_max = 7, second_max = 2
    *       2,7,9 -> 2+9=11  11>7 the_max = 11, second_max = 7
    *       2,7,9,3 -> 11>(7+3) the_max = 11, second_max = 10
    *       2,7,9,3,1 -> 11+1 = 12
    *
    * */
    public int rob(int[] nums) {
        int the_max_sum = nums [0];
        int second_max_sum = 0;
        int last_element = 0;
        for(int i = 1;i<nums.length;i++){
            int current_element = nums [i];
            if(i == last_element+1){
                int new_sum = current_element + second_max_sum;
                if(new_sum>the_max_sum) {
                    second_max_sum = the_max_sum;
                    the_max_sum = new_sum;
                    last_element = i;
                }
            }else{
                second_max_sum = the_max_sum;
                the_max_sum+=current_element;
                last_element = i;
            }
        }
        return  the_max_sum;
    }
}

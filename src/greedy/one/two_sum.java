package greedy.one;

import java.util.HashMap;
import java.util.Map;

public class two_sum {

    public static void main(String[] args) {
        int [] t = {2,7,11,15};
        int [] r = new two_sum().twoSum(t,13);
        for(int i:r){
            System.out.println(i);
        }
    }

    // hashmap
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0;i<len;i++){
            int t_ = target - nums[i];
            if(map.containsKey(t_)&&map.get(t_)!=i){
                return new int[]{i,map.get(t_)};
            }
            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }

    // double pointer
    public int[] twoSum_(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        //Arrays.sort(nums);
        while(right>left){
            int sum = nums[right]+nums[left];
            if(sum == target){
                return new int [] {left,right};
            }else if(sum>target){
                right--;
            }else{
                 left++;
            }
        }

        return new int[]{-1,-1};
    }

}



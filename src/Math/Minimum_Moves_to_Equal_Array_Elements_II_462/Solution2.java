package Math.Minimum_Moves_to_Equal_Array_Elements_II_462;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Solution2 {
    public static void main(String[] args) {
        int [] num = {1,10,2,9};
        int [] num2 = {1,2,100,100,100,100,100,100};
        int [] num3 = {1,2,100};
        int [] num4 = {1,0,0,8,6};
        int [] num5 = {203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143};
        int [] num6 = {2,3,1};
        int r = new Solution2().minMoves2(num5);
        System.out.println(r);

        //new Solution2().quickSort(num,0,3);
        //Arrays.stream(num).forEach(x -> System.out.println(x));
    }

    public int minMoves2(int[] nums) {
        int len = nums.length;
        if(len<2)
            return 0;
        int sum = 0;

        // arrays.sort : 11ms
        //int [] arr = Arrays.stream(nums).boxed().sorted(Comparator.naturalOrder()).mapToInt(Integer::intValue).toArray();
        // qucksort : 4ms
        int [] arr = Arrays.copyOf(nums,nums.length);
        quickSort(arr,0,arr.length-1);

        int median = len%2==1?arr[len/2]:(arr[len/2]+arr[len/2-1])/2;
        for(int i:arr)
            sum += Math.abs(i-median);

        return sum;
    }

    public void quickSort(int[] nums,int left,int right){
        if(left<right) {
            int p = randomPartition(nums, left, right);
            quickSort(nums,left,p-1);
            quickSort(nums,p+1,right);
        }
    }

    // this is very very very important to the efficiency of sort
    public int randomPartition(int[] array, int l, int r) {
        int i = new Random().nextInt(r-l+1) + l;
        swap(array, i, l);
        return partition(array, l, r);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public void swap(int [] array, int x, int y){
        int temp = array [x];
        array [x] = array [y];
        array [y] = temp;
    }

}

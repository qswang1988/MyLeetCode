package sort.three_fourtyseven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int [] nums2 = {3,0,1,0};
        int [] r = new Solution().topKFrequent(nums2,1);
        for(int i:r)
            System.out.print(i+", ");
    }

    public int[] topKFrequent(int[] array, int k) {
        int [] nums = Arrays.copyOf(array,array.length);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);

        int [] elements = new int [map.size()];
        int [] frequency = new int [map.size()];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            elements [index] = entry.getKey();
            frequency [index++] = entry.getValue();
        }

        int len = frequency.length;
        // build min heap
        for(int i = len/2;i>=0;i--)
            heapify(frequency,elements,i,len);
        // sort
        for(int i = len-1;i>=0;i--){
            swap(frequency,elements,0,i);
            heapify(frequency,elements,0,i);
        }

        int [] r = new int [k];
        System.arraycopy(elements,0,r,0,k);

        return r;
    }

    public void heapify(int [] array,int [] elements,int i, int len){
        int left_node = 2*i+1;
        int right_node = 2*i + 2;
        int smallest = i;
        if(left_node<len && array[left_node]<array[smallest])
            smallest = left_node;
        if(right_node<len && array[right_node]<array[smallest])
            smallest = right_node;
        if(smallest!=i){
            swap(array,elements,i,smallest);
            heapify(array,elements,smallest,len);
        }
    }

    public void swap(int [] array, int [] elements, int x, int y){
        int temp = array [x];
        array [x] = array [y];
        array [y] = temp;

        temp = elements [x];
        elements [x] = elements [y];
        elements [y] = temp;
    }
}

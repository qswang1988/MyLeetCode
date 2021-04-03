package sort.two_fiveteen;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int [] nums2 = {3,2,1,5,6,4};
        int k = 4;
        int r = new Solution().findKthLargest(nums2,1);
        System.out.println(r);
    }

    // <heapsort>

    public int findKthLargest(int[] nums, int k) {
        int [] array = Arrays.copyOf(nums,nums.length);

        // build a maxheap, loop a node which has at least one branch
        for(int i = array.length/2;i>=0;i--){
            heapify(array,i,array.length);
        }

        /*System.out.println("after maxheap");
        for(int i:array)
            System.out.print(i+",");
        System.out.println();*/

        // replace the root with the last element
        // everytime, the largest element will be moved from the root node the the last node.
        // so you only need k times loop to get the Kth largest element
        //for(int i = array.length-1;i>=0;i--){
        for(int i = array.length-1;i>=array.length-k;i--){
            swap(array,0,i);
            heapify(array,0,i);
        }

        /*for(int i:array)
            System.out.print(i+",");
        System.out.println();*/

        return array [array.length-k];
    }

    public void heapify(int [] array,int i, int len){
        int left_node = 2*i+1;
        int right_node = 2*i + 2;
        int largest = i;
        if(left_node<len && array[left_node]>array[largest])
            largest = left_node;
        if(right_node<len && array[right_node]>array[largest])
            largest = right_node;
        if(largest!=i){
            swap(array,i,largest);
            heapify(array,largest,len);
        }
    }

    public void swap(int [] array, int x, int y){
        int temp = array [x];
        array [x] = array [y];
        array [y] = temp;
    }



    // </heapsort>

/*    // <quicksort>

    public int findKthLargest(int[] nums, int k) {
        int [] array = Arrays.copyOf(nums,nums.length);
        int [] sortedArray = quickSort(array,0,nums.length-1,k);
        *//*for(int i:sortedArray)
            System.out.print(" "+i);*//*
        return sortedArray [sortedArray.length-k];
    }

    public int [] quickSort(int[] nums,int left,int right, int k){
        int p = randomPartition(nums,left,right);
        if(p<0||(nums.length-k)==p)
            return nums;
        if((nums.length-k)<p)
            return quickSort(nums,0,p-1,k);
        else if((nums.length-k)>p)
            return quickSort(nums,p+1,right,k);
        return nums;
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

    // </quicksort>*/


/*    // bucket sort
    // flexible bucket size & bucket amount
    public int findKthLargest(int[] nums, int k) {
        int bucketSize = k+1;
        int [][] sortedArray = sort(nums,bucketSize);

        int counter = 0;
        int i;
        for(i = sortedArray.length - 1;i>=0;i--){
            int len = sortedArray [i].length;
            //counter+=len;
            if(counter+len>=k)
                break;
            counter+=len;
        }
        int [] r = Arrays.stream(sortedArray[i]).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        *//*System.out.println("counter: "+counter+"\n");
        for(int l:r){
            System.out.print(l+" ,");
        }*//*
        return r [k-counter-1];
    }

    public int [][] sort(int [] nums , int bucketSize){
        int [] array = Arrays.copyOf(nums,nums.length);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:array){
            if(i<min)
                min = i;
            if(i>max)
                max = i;
        }
        *//*System.out.println(min);
        System.out.println(max);*//*

        int bucketNum = (int)Math.floor((double)(max - min)/bucketSize)+1;
        //System.out.println(bucketNum);
        int [][] sorted = new int [bucketNum][0];

        // put elements into respective bucket
        for(int i:array){
            int bucketIndex = (int)Math.floor((double)((i-min)/bucketSize));
            //System.out.println("bucketIndex: "+bucketIndex);
            sorted[bucketIndex] = arrayAppend(sorted [bucketIndex],i);
        }

        *//*for(int [] a:sorted){
            System.out.println("--");
            for(int i:a)
                System.out.print(i+" , ");
        }*//*


        return sorted;
    }

    public int [] arrayAppend(int [] nums, int element){
        int [] array = Arrays.copyOf(nums,nums.length+1);
        array [array.length-1] = element;
        return array;
    }*/



/*    public int findKthLargest(int[] nums, int k) {
        int [] array = Arrays.copyOf(nums,nums.length);

        for(int i = 0;i<k;i++){

            int largest = Integer.MIN_VALUE;
            int largest_pos = -1;
            for(int j = i;j<array.length;j++){
                if(array [j]> largest){
                    largest_pos = j;
                    largest = array [j];
                }
            }
            int temp = array [i];
            array [i] = array [largest_pos];
            array [largest_pos] = temp;
        }


        return array [k-1];
    }*/


/*    public int findKthLargest(int[] nums, int k) {
        int largestElement = Integer.MIN_VALUE;
        for(int i:nums){
            if(i>largestElement)
                largestElement = i;
        }
        //System.out.println(largestElement);
        int [] counter = new int [largestElement+1];
        for(int i:nums)
            counter [i]++;
        //Arrays.stream(counter).forEach(System.out::println);
        int limit = 0;
        for(int i = counter.length-1;i>0;i--){
            if(counter[i] == 0)
                continue;
            limit += counter [i];
            if(limit>=k)
                return i;
        }

        return 0;
    }*/


    /*public int findKthLargest(int[] nums, int k) {
        int [] num = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        return num [k-1];
    }*/


    /*
    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:nums){
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        System.out.println(map.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
        List<Integer> list = map.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for(int l:list){
            System.out.println("key: "+ l+" ,amount: "+map.get(l));
        }
        int count = 0;
        for(int i = 0;;i++){
            int key = list.get(i);
            System.out.println("key: "+key);
            System.out.println("amount: "+map.get(key));
            count+= map.get(key);
            System.out.println("count: "+count);
            if(count>=k)
                return key;
        }
    }
    */
}

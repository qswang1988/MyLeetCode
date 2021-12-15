package data_structure.MaxChunksToMakeSorted_769;

import java.util.*;

/*
*   https://leetcode.com/problems/max-chunks-to-make-sorted/submissions/
*   Medium
*
* */
public class Solution {
    public static void main(String[] args) {
        int [] arr = {1,0,2,3,4};
        int r = new Solution().maxChunksToSorted(arr);
        System.out.println(r);
    }

    public int maxChunksToSorted(int[] arr) {
        int [] sorted = Arrays.copyOf(arr,arr.length);
        Arrays.sort(sorted);

        int NumOfChunks = 0;
        Set<Integer> setSorted = new HashSet<>();
        Set<Integer> setArr = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            setSorted.add(sorted[i]);
            setArr.add(arr[i]);
            if(setSorted.equals(setArr)){
                NumOfChunks++;
                setSorted.clear();
                setArr.clear();

            }
        }

        return NumOfChunks == 0?1:NumOfChunks;
    }
}

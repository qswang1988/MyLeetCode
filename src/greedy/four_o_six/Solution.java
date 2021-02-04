package greedy.four_o_six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int [][] in = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
                    // [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

        int [][] r = new Solution().reconstructQueue(in);
        Arrays.stream(r).forEach(x-> System.out.print(x[0]+" - "+x[1]+", "));
    }

    public int[][] reconstructQueue(int[][] people) {

        // 排序重点是按照 身高hi 由高到低， ki 有小到大
        Arrays.sort(people,(x,y)->{
            if(x[0]!=y[0])
                return -Integer.compare(x[0],y[0]);
            else
                return Integer.compare(x[1],y[1]);
        });

        /*
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.stream(people).forEach(x->list.add(x));
        for(int i = 0;i<list.size();i++){
            if(list.get(i)[1]<i){
                int [] curr = list.get(i);
                list.add(list.get(i)[1],curr);
                list.remove(i+1);

            }
        }
        int [][] r = new int [list.size()][];
        for(int i = 0;i<list.size();i++){
            r[i] = list.get(i);
        }

         */
        // 我之前是先将排序好的数组转成list,再将list的元素x 按照 当 x[1]<i 时，将 x 插入到
        // list 的第 i 位置
        // 其实 按照这个逻辑，根本不需要那么复杂。只需要直接把 数组 插入到 新list的 第 i 位，就好了。
        // 效果是 一样 的，还省了很多步骤
        List<int[]> list = new ArrayList<>();
        for(int[] p:people){
            list.add(p[1],p);
        }

        return list.toArray(new int[list.size()][]);
    }
}

package greedy.four_fortyfive;

/*
* Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:

Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all of the children,
You need to output 2.
* */

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int[] g1 = {262,437,433,102,438,346,131,160,281,34,219,373,466,275,51,118,209,32,108,57,385,514,439,73,271,442,366,515,284,425,491,466,322,34,484,231,450,355,106,279,496,312,96,461,446,422,143,98,444,461,142,234,416,45,271,344,446,364,216,16,431,370,120,463,377,106,113,406,406,481,304,41,2,174,81,220,158,104,119,95,479,323,145,205,218,482,345,324,253,368,214,379,343,375,134,145,268,56,206};
        int[] s1 = {149,79,388,251,417,82,233,377,95,309,418,400,501,349,348,400,461,495,104,330,155,483,334,436,512,232,511,40,343,334,307,56,164,276,399,337,59,440,3,458,417,291,354,419,516,4,370,106,469,254,274,163,345,513,130,292,330,198,142,95,18,295,126,131,339,171,347,199,244,428,383,43,315,353,91,289,466,178,425,112,420,85,159,360,241,300,295,285,310,76,69,297,155,416,333,416,226,262,63,445,77,151,368,406,171,13,198,30,446,142,329,245,505,238,352,113,485,296,337,507,91,437,366,511,414,46,78,399,283,106,202,494,380,479,522,479,438,21,130,293,422,440,71,321,446,358,39,447,427,6,33,429,324,76,396,444,519,159,45,403,243,251,373,251,23,140,7,356,194,499,276,251,311,10,147,30,276,430,151,519,36,354,162,451,524,312,447,77,170,428,23,283,249,466,39,58,424,68,481,2,173,179,382,334,430,84,151,293,95,522,358,505,63,524,143,119,325,401,6,361,284,418,169,256,221,330,23,72,185,376,515,84,319,27,66,497};
        int r = new Solution().findContentChildren(g,s);
        System.out.println(r);
    }

    public int findContentChildren(int[] g, int[] s) {

        //int r = 0; // num of children who is content
        int g_len = g.length;
        int s_len = s.length;

        if(s_len==0||g_len==0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        //ArrayList<Integer> s_ = (ArrayList<Integer>) Arrays.stream(s).boxed().collect(Collectors.toList());
        // 贪心算法解题思路。从左往右，分别是从小到大的两个数组。这时尽量确保饥饿度小的孩子先被满足。所以两个
        //数组同时从左往右算，遇到不能满足的时候，就试试下一个饼干SIZE。
        // [1,1,2,2,3,3,4]
        // [1,2,2,3,3,4,5,6]

        int is = 0,ig = 0;
        while(true){
            if(is>s_len-1||ig>g_len-1)
                break;
            if(g[ig]<=s[is]){
                //r++; 每次R++的时候，IG也++，所以就直接返回IG了
                is++;
                ig++;
                continue;
            }else{
                is++;
            }
        }
        return ig;
    }
}
package Random.Twelve;

public class Solution2 {
    public static void main(String[] args) {
        int test = 1994;
        String result = intToRoman(test);
        System.out.println(result);
    }

    public static String intToRoman(int num) {
        int[] unit = {1000, 900, 500, 400, 100, 90, 50, 40, 10 , 9, 5, 4, 1};
        String[] mark = {"M", "CM", "D" , "CD" , "C" ,"XC", "L", "XL", "X" ,"IX", "V" ,"IV", "I"};
        StringBuilder sb = new StringBuilder("");
        int res = num;
        int pos = 0;
        while(res>0) {
            int count = res/unit[pos];
            if(count > 0) {
                sb.append(mark [pos].repeat(count));
                res = res%unit[pos];
            }
            pos++;
        }
        return sb.toString();
    }
}

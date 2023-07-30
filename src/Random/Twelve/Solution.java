package Random.Twelve;

public class Solution {

    public static void main(String[] args) {
        int test = 1994;
        String result = intToRoman(test);
        System.out.println(result);
    }

    public static String intToRoman(int num) {
        int [] unit_a = {1000,100,10,1};
        String [] mark_a = {"M","C","X","I"};
        int [] unit_b = {500,50,5};
        String [] mark_b = {"D","L","V"};
        StringBuilder sb = new StringBuilder("");

        int pos_a = 0;
        int pos_b = 0;
        int rest = num;

        while(rest>0){
            int current_unit = unit_a [pos_a];
            if(rest < current_unit) {
                pos_a ++;
                continue;
            } else if(unit_b [pos_b] / current_unit > 5) {
                pos_b ++;
                continue;
            }

            int num_of_current_unit = rest / current_unit;
            if(num_of_current_unit == 9) {
                sb.append(mark_a [pos_a]);
                sb.append(mark_a [pos_a - 1]);
                rest = rest - unit_a [pos_a - 1] + current_unit;
                pos_a ++;
            }else if(num_of_current_unit >= 5) {
                sb.append(mark_b [pos_b]);
                rest = rest - 5 * current_unit;
            }else if(num_of_current_unit == 4) {
                sb.append(mark_a [pos_a]);
                sb.append(mark_b [pos_b]);
                rest = rest - 4 * current_unit;
                pos_a ++;
            } else {
                sb.append(mark_a [pos_a].repeat(num_of_current_unit));
                rest = rest % current_unit;
                pos_a ++;
            }
        }

        return sb.toString();
    }

}

package Math.Adding_Strings_415;

public class Solution {
    public static void main(String[] args) {
        String r = new Solution().addStrings("123","937");
        System.out.println(r);
    }

    public String addStrings(String num1, String num2) {
        int [] s = new int [Integer.max(num1.length(),num2.length())+1];
        int count = 0;
        int carry = 0;
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();

        while(len1>=0||len2>=0||carry>0){
            int a = len1>=0?num1.charAt(len1--)-'0':0;
            int b = len2>=0?num2.charAt(len2--)-'0':0;
            int sum = carry+a+b;
            s [count++] = sum%10;
            carry = sum/10;
        }

        for(int i = count-1;i>=0;i--)
            sb.append(s[i]);

        return sb.toString();
    }

    /*public String addStrings(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        StringBuilder sb = new StringBuilder();
        int [] s = new int [Integer.max(num1.length(),num2.length())+1];
        int count = 0;
        int carry = 0;
        while(n1>0||n2>0||carry>0){
            int a = n1%10;
            int b = n2%10;

            n1 = n1/10;
            n2 = n2/10;

            int sum = a+b+carry;
            s [count] = sum%10;
            carry = sum/10;
            count++;
        }

        //for(int i:s)
        //    System.out.println(i);

        for(int i = s.length-1;i>=0;i--){
            if(s[i]==0&&i==s.length-1)
                continue;
            sb.append(s[i]);
        }

        return sb.toString();
    }*/
}

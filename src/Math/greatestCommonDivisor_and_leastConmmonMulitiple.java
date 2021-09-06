package Math;

public class greatestCommonDivisor_and_leastConmmonMulitiple {

    public static void main(String[] args) {
        System.out.println(gcm(15,25));
        System.out.println(lcm(12,15));
    }

    public static int gcm(int a,int b){
        return b==0?a:gcm(b,a%b);
    }

    public static int lcm(int a,int b){
        return a*b/gcm(a,b);
    }

}

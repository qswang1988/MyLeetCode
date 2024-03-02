package greedy.six_O_five;

public class Redo {

    public static void main(String[] args) {
        int [] f1 = {1,0,0,0,1};
        int [] f2 = {1,0,0,0,1};
        int n = 1;
        boolean r = new Redo().canPlaceFlowers(f2,1);
        System.out.println(r);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0; // current index
        int len = flowerbed.length;
        while (n > 0 && i < len) {
            if(flowerbed [i] == 0) {
                boolean canBeInsertedHere = true;
                if(i > 0 && flowerbed [i-1] == 1) {
                    canBeInsertedHere = false;
                } else if(i < len - 1 && flowerbed [i + 1] == 1) {
                    canBeInsertedHere = false;
                }
                if(canBeInsertedHere) {
                    flowerbed [i] = 1;
                    n--;
                }
            }
            i++;
        }

        return n == 0;
    }
}

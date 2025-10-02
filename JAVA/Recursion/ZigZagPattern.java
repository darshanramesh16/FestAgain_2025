public class ZigZagPattern {
    public static void pip(int n) {
        if (n == 0)
            return;
        System.out.print(n);// PRE : dono call ke pehle ka kaam.......
        pip(n - 1);
        System.out.print(n);// IN : dono call ke beech ka kaam.......
        pip(n - 1);
        System.out.print(n);// POST : dono call ke baad ka kaam.......
    }

    public static void main(String[] args) {
        pip(2);
    }
}

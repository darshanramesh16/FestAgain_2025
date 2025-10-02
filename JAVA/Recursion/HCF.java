public class HCF {
    public static int FindHcf(int divider, int divident) {
        if (divident % divider == 0) // if remainder is 0................
            return divider;
        return FindHcf(divident % divider, divider);
    }

    public static void main(String[] args) {
        System.out.println(FindHcf(30, 96));
    }
}

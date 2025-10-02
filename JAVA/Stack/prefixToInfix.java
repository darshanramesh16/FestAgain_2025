import java.util.Stack;

public class prefixToInfix {
    public static String prefixToinfixconvert(String str) {
        int n = str.length();
        Stack<String> num = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                num.push(ch + "");
            } else {
                String op1 = num.pop();
                String op2 = num.pop();
                char per = ch;
                String ans = "";
                ans = '(' + op1 + ch + op2 + ')';
                num.push(ans);
            }
        }
        return num.peek();
    }

    public static void main(String[] args) {
        String post = "-9/*+5346";
        String ans = prefixToinfixconvert(post);
        System.out.println(ans);
    }
}

import java.util.Stack;

public class PostEval {
    public static int PrefixEval(String str) {
        int n = str.length();
        Stack<Integer> num = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                num.push(ch - '0');
            } else {
                int op2 = num.pop();
                int op1 = num.pop();
                char per = ch;
                int ans = 0;
                switch (per) {
                    case '+':
                        ans = op1 + op2;
                        break;
                    case '-':
                        ans = op1 - op2;
                        break;
                    case '/':
                        ans = op1 / op2;
                        break;
                    case '*':
                        ans = op1 * op2;
                        break;
                }
                num.push(ans);
            }
        }
        return num.peek();
    }

    public static void main(String[] args) {
        String prfix = "953+4*6/-";
        int ans = PrefixEval(prfix);
        System.out.println(ans);
    }
}

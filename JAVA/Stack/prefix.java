import java.util.Stack;

public class prefix {
    public static String PrefixEval(String str) {
        int n = str.length();
        Stack<String> num = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                num.push(ch + "");
            } else if (oper.empty()) {
                oper.push(ch);
            } else if (ch == '(') {
                oper.push(ch);
            } else if (ch == ')') {
                while (num.size() > 1 && oper.peek() != '(') {
                    String op2 = num.pop();
                    String op1 = num.pop();
                    char per = oper.pop();
                    String ans = per + op1 + op2;
                    num.push(ans);
                }
                oper.pop();// to remove the "(" bracket............
            } else if (ch != ')' && oper.peek() == '(') {
                oper.push(ch);
            } else if ((ch == '/' && (oper.peek() == '*' || oper.peek() == '/'))
                    || (ch == '*' && (oper.peek() == '*' || oper.peek() == '/'))) {
                String op2 = num.pop();
                String op1 = num.pop();
                char per = oper.pop();
                String ans = per + op1 + op2;
                num.push(ans);
                oper.push(ch);
            } else if ((ch == '/' && (oper.peek() == '+' || oper.peek() == '-'))
                    || (ch == '*' && (oper.peek() == '+' || oper.peek() == '-'))) {
                oper.push(ch);
            } else {
                String op2 = num.pop();
                String op1 = num.pop();
                char per = oper.pop();
                String ans = per + op1 + op2;
                num.push(ans);
                oper.push(ch);
            }
        }
        while (num.size() > 1) {
            String op2 = num.pop();
            String op1 = num.pop();
            char per = oper.pop();
            String ans = per + op1 + op2;
            num.push(ans);
        }
        return num.peek();
    }

    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        String ans = PrefixEval(infix);
        System.out.println(ans);
    }
}

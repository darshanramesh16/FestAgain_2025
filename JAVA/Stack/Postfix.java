import java.util.Stack;

public class Postfix {
    // public static String Post1(String str) {
    // int n = str.length();
    // Stack<String> num = new Stack<>();
    // Stack<Character> oper = new Stack<>();
    // for (int i = 0; i < n; i++) {
    // char ch = str.charAt(i);
    // int ascii = (int) ch;
    // if (ascii >= 48 && ascii <= 57) {
    // num.push(ch + "");
    // } else if (oper.empty()) {
    // oper.push(ch);
    // } else if (ch == '(') {
    // oper.push(ch);
    // } else if (ch == ')') {
    // while (num.size() > 1 && oper.peek() != '(') {
    // String op2 = num.pop();
    // String op1 = num.pop();
    // char per = oper.pop();
    // String ans = op1 + op2 + per;
    // num.push(ans);
    // }
    // oper.pop();// to remove the "(" bracket............
    // } else if (ch != ')' && oper.peek() == '(') {
    // oper.push(ch);
    // } else if ((ch == '/' && (oper.peek() == '*' || oper.peek() == '/'))
    // || (ch == '*' && (oper.peek() == '*' || oper.peek() == '/'))) {
    // String op2 = num.pop();
    // String op1 = num.pop();
    // char per = oper.pop();
    // String ans = op1 + op2 + per;
    // num.push(ans);
    // oper.push(ch);
    // } else if ((ch == '/' && (oper.peek() == '+' || oper.peek() == '-'))
    // || (ch == '*' && (oper.peek() == '+' || oper.peek() == '-'))) {
    // oper.push(ch);
    // } else {
    // String op2 = num.pop();
    // String op1 = num.pop();
    // char per = oper.pop();
    // String ans = op1 + op2 + per;
    // num.push(ans);
    // oper.push(ch);
    // }
    // }
    // while (num.size() > 1) {
    // String op2 = num.pop();
    // String op1 = num.pop();
    // char per = oper.pop();
    // String ans = op1 + op2 + per;
    // num.push(ans);
    // }
    // return num.peek();
    // }

    static int precedence(Character ch) {// effective method...........
        switch (ch) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                break;
        }
        return -1;
    }

    static boolean isCharacter(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
            return true;
        }
        return false;
    }

    static String Post(String str) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (st.empty() && isCharacter(ch)) {
                st.push(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            } else if (!isCharacter(ch)) {
                ans.append(ch);
            } else {
                if (!st.empty() && precedence(ch) <= precedence(st.peek())) {
                    ans.append(st.pop());
                    st.push(ch);
                } else {
                    st.push(ch);
                }
            }
        }
        while (!st.empty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        String ans = Post(infix);
        System.out.println(ans);
    }
}

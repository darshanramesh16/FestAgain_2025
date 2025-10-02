import java.util.Stack;

public class infix {
    public static int InfixEval(String str) {
        int n = str.length();
        Stack<Integer> num = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                num.push(ch - '0');
            } else if (oper.empty()) {
                oper.push(ch);
            } else if (ch == '(') {
                oper.push(ch);
            } else if (ch == ')') {
                while (num.size() > 1 && oper.peek() != '(') {
                    int op2 = num.pop();
                    int op1 = num.pop();
                    char per = oper.pop();
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
                oper.pop();
            } else if (ch != ')' && oper.peek() == '(') {
                oper.push(ch);
            } else if ((ch == '/' && (oper.peek() == '*' || oper.peek() == '/'))
                    || (ch == '*' && (oper.peek() == '*' || oper.peek() == '/'))) {
                int op2 = num.pop();
                int op1 = num.pop();
                char per = oper.pop();
                int ans = 0;
                switch (per) {
                    case '/':
                        ans = op1 / op2;
                        break;
                    case '*':
                        ans = op1 * op2;
                        break;
                }
                num.push(ans);
                oper.push(ch);
            } else if ((ch == '/' && (oper.peek() == '+' || oper.peek() == '-'))
                    || (ch == '*' && (oper.peek() == '+' || oper.peek() == '-'))) {
                oper.push(ch);
            } else {
                int op2 = num.pop();
                int op1 = num.pop();
                char per = oper.pop();
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
                oper.push(ch);
            }
        }
        while (num.size() > 1) {
            int op2 = num.pop();
            int op1 = num.pop();
            char per = oper.pop();
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
        return num.peek();
    }

    public static void main(String[] args) {
        String infix = "(9-(((5+3)*4)/6))";
        int ans = InfixEval(infix);
        System.out.println(ans);
    }
}

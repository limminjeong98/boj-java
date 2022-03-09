package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/4949
// 균형잡힌 세상
public class N4949 {
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            flag = false;
            int n = str.length();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                // 괄호만 저장
                if (stack.isEmpty()) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']') {
                        stack.push(str.charAt(i));
                    }
                } else {
                    if (stack.peek() == '(' && str.charAt(i) == ')') {
                        stack.pop();
                    } else if (stack.peek() == '[' && str.charAt(i) == ']') {
                        stack.pop();
                    } else {
                        if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']') {
                            stack.push(str.charAt(i));
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {
                flag = true;
            }

            // valid
            if (!flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}

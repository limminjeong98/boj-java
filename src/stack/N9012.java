package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
// 괄호
public class N9012 {
    static int n;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            flag = false;
            String ps = br.readLine();
            int length = ps.length();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < length; j++) {
                if (stack.isEmpty()) stack.push(ps.charAt(j));
                else {
                    if (stack.peek() == '(' && ps.charAt(j) == ')') {
                        stack.pop();
                    } else {
                        stack.push(ps.charAt(j));
                    }
                }
            }
            if (!stack.isEmpty()) flag = true;
            // valid
            if (!flag) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}

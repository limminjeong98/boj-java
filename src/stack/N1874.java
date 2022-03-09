package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
// 스택 수열
public class N1874 {
    static int n, tmp;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        flag = false;
        Stack<Integer> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        int now = 1;
        for (int i = 0; i < n; i++) {
            if (flag) break;
            tmp = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                stack.push(now);
                now++;
                ans.add("+");
            }
            while (stack.peek() < tmp) {
                stack.push(now);
                now++;
                ans.add("+");
            }
            if (stack.peek() == tmp) {
                stack.pop();
                ans.add("-");
            }
            while (!stack.isEmpty() && stack.peek() > tmp) {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println("NO");
        else {
            for (String a : ans) {
                System.out.println(a);
            }
        }
    }
}

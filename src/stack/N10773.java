package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/10773
// 제로
public class N10773 {
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int tmp;
        for (int i = 0; i < k; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                stack.pop();
            } else {
                stack.push(tmp);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}

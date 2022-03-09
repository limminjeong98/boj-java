package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17298
// 오큰수
public class N17298 {
    static int n;
    static int[] arr;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ans = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans[i] = -1;
        }
        Stack<Integer[]> stack = new Stack<>();
        int idx = 0;
        while (idx < n) {
            if (stack.isEmpty()) stack.push(new Integer[]{idx, arr[idx]});
            else {
                // stack 이 비어 있지 않을 때까지 반복
                while (!stack.isEmpty()) {
                    Integer[] top = stack.peek();
                    if (top[1] < arr[idx]) {
                        stack.pop();
                        // 스택에 들어있는 원소들 중에서 리스트의 현재 idx 값보다 작으면
                        // pop하고 왼쪽 방향의 다음 원소를 확인
                        // stack.push(new Integer[] {idx, arr[idx]});
                        ans[top[0]] = arr[idx];
                        // 리스트의 현재 idx 값이 스택 최상단 값보다 작으면
                        // "오큰수"로서 이 값을 참조할 원소들이 없음
                    } else {
                        // 반복문 종료
                        // stack.push(new Integer[] {idx, arr[idx]});
                        break;
                    }
                }
                // 현재 원소에 대해서도 오큰수 탐색이 필요하므로 넣어줌
                stack.push(new Integer[]{idx, arr[idx]});
            }
            idx++;
        }
        // 출력 시간초과
        // for (int i = 0; i < n; i++) {
        //     System.out.print(ans[i] + " ");
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb);
    }
}

package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1003
// 피보나치 함수
public class N1003 {
    static int t, n;
    static int[] dp0;
    static int[] dp1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp0 = new int[41];
        dp1 = new int[41];
        dp0[0] = 1;
        dp0[1] = 0;
        dp1[0] = 0;
        dp1[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp0[i] = dp0[i - 1] + dp0[i - 2];
            dp1[i] = dp1[i - 1] + dp1[i - 2];
        }
        StringBuilder sb;
        for (int i = 0; i < t; i++) {
            sb = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            sb.append(dp0[n]).append(' ').append(dp1[n]);
            System.out.println(sb);
        }
    }
}

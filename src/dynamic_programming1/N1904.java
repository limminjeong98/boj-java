package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1904
// 01타일
public class N1904 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        // 타일 1장으로 만들 수 있는 2진 수열
        dp[0] = 1; // 1
        if (n == 1) {
            // 타일이 1장일 경우 dp[1] ArrayIndexOutOfBounds 런타임 에러 발생.
            // 아래서 인덱스 접근 못하게 종료 바로 해야함
            System.out.println(dp[n - 1]);
            return;
        }
        // 타일 2장으로 만들 수 있는 2진 수열
        dp[1] = 2; // 11, 00
        // 타일 3장으로 만들 수 있는 2진 수열
        // dp[2] = 3; // 111, 100, 001
        // 타일 4장으로 만들 수 있는 2진 수열
        // dp[3] = 5; // 1111, 1100, 1001, 0011, 0000
        // 타일 5장으로 만들 수 있는 2진 수열
        // dp[4] = 8; // 11111, 11100, 11001, 10011, 00111, 10000, 00100, 00001
        for (int i = 2; i < n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[n - 1]);
    }
}

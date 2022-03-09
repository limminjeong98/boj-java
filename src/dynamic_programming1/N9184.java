package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9184
// 신나는 함수 실행
public class N9184 {
    static int a, b, c;
    static int[][][] dp;

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        // dp[20][20][20]을 계산한 값이 없을 경우 호출을 해줘야 함
        // 여러번 호출하는 대신 미리 계산했음
        if (a > 20 || b > 20 || c > 20) return dp[20][20][20];
        // return dp[20][20][20] = w(20, 20, 20);
        if (dp[a][b][c] != 0) return dp[a][b][c];
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        dp = new int[21][21][21];
        // 미리 호출해서 계산
        dp[20][20][20] = w(20, 20, 20);
        // for (int i = 0; i < 21; i++) {
        //     Arrays.fill(dp[0][i], 1); // [0][0][0] ~ [0][20][20]
        //     Arrays.fill(dp[i][0], 1); // [0][0][0] ~ [20][0][20]
        // }
        // dp[0][0][0] = 1;
        StringBuilder sb;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb = new StringBuilder();
//            if (a <= 0 || b <= 0 || c <= 0) {
//                System.out.println(sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(1));
//            }
//            if (a > 20 || b > 20 || c > 20) {
//                System.out.println(sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(dp[20][20][20]));
//            }
            System.out.println(sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)));
        }

    }
}

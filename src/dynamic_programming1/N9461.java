package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9461
// 파도반 수열
public class N9461 {
    // 문제에서 별도 언급 없으면 int 말고 long 범위를 생각
    // long 자료형으로 해야하는 변수 꼼꼼히 확인
    static long t;
    static int n;
    static long[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Long.parseLong(br.readLine());
        p = new long[100];
        p[0] = 1;
        p[1] = 1;
        p[2] = 1;
        p[3] = 2;
        p[4] = 2;
        p[5] = 3;
        p[6] = 4;
        p[7] = 5;
        p[8] = 7;
        p[9] = 9;
        for (int i = 10; i < 100; i++) {
            p[i] = p[i - 5] + p[i - 4] + p[i - 3];
        }
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(p[n - 1]);
        }
    }
}

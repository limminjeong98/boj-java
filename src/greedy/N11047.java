package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11047
// 동전 0
public class N11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        // 동전의 개수 무한하다고 가정
        // 가능한 큰 금액의 동전으로 먼저 나누기
        // int[] 면 Comparator 인터페이스의 reverseOrder 메서드 사용 못함
        Arrays.sort(a, Comparator.reverseOrder());
        // 항상 k원을 만들 수 있다고 가정
        int ans = 0;
        for (int coin : a) {
            ans += k / coin;
            k %= coin;
        }
        System.out.println(ans);
    }
}

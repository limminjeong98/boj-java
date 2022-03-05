package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13305
// 주유소
public class N13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n - 1];
        long[] oil = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil[i] = Long.parseLong(st.nextToken());
        }
        long ans = dist[0] * oil[0];
        // 시작할 때는 무조건 이만큼은 충전해서 가야 함
//        int curOil = dist[0] * oil[0];
        // 현재 도시의 왼쪽까지 있는 주유소에서의 리터당 최저 가격
        long curMin = oil[0];
        for (int i = 1; i < n - 1; i++) {
            if (curMin > oil[i]) {
                curMin = oil[i];
            }
            ans += dist[i] * curMin;
        }
        System.out.println(ans);
    }
}

package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11404
// 플로이드
public class N11404 {
    static int n, m;
    static int map[][];
    // overflow 방지하려면 아래 같이
    // 문제에서는 100000(각 버스의 최대 비용) * 100(전체 도시의 수) 이하라고 주어짐
    // a -> b 까지 가는데 모든 도시를 경우해야 하고,각 경우에서 최대 비용일 때를 최대치라고 생각
     static int INF = Integer.MAX_VALUE / 2 - 1;
//    static int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], INF);
//            map[i][i] = 0;
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다
            if (map[a - 1][b - 1] > c) map[a - 1][b - 1] = c;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    // int + int 에서 overflow 되는 경계 주의해서 최대값 설정하기
                    if (map[j][i] + map[i][k] < map[j][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

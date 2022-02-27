package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2606
// 바이러스
public class N2606 {
    static int n, m;
    static int map[][];
    static boolean visited[];
    static int cnt;
    public static void dfs(int node) {
        visited[node] = true;
        cnt++;
        for (int nextNode = 0; nextNode < n; nextNode++) {
            if (map[node][nextNode] == 1 && visited[nextNode] == false) {
                dfs(nextNode);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 0);
        }
        visited = new boolean[n];
        cnt = 0;
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = map[b - 1][a - 1] = 1;
        }
        dfs(0);
        System.out.println(cnt - 1);
    }
}

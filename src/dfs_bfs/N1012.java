package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1012
// 유기농 배추
public class N1012 {
    static int T;
    static int n, m, k;
    // int[][] 보다 메모리 적게 필요
    static boolean[][] map;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    // 묶음이 몇개인지 탐색하는 경우는 dfs로 풀기
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
            if (!map[nx][ny]) continue;
            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new boolean[n][m];
            visited = new boolean[n][m];
            // boolean[][] 은 처음에 false로 초기화되어있음
            // 따라서 입력으로 주어진 칸만 true로 초기화하면 됨
            k = Integer.parseInt(st.nextToken());
            int x, y;
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // true이고 처음 방문하는 배열이면 dfs 탐색
                    if (map[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}

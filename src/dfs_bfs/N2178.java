package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178
// 미로 탐색
public class N2178 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    // static int[][] map; 이렇게 풀면 메모리 초과
    // map은 처음에는 1 또는 0으로만 채워져있지만
    // 이동을 하면서 1이 있던 칸은 현재칸까지의 최소이동횟수로 갱신함
    // 현재값이 1이 아닌데 방금 탐색한 칸 + 1보다 값이 작으면 탐색하지 않음
    // (위에가 처음에 생각한 방법)
    //
    static boolean[][] map;
    // 갈 수 있는 칸은 true, 없는 칸은 false로 초기화
    // 방문한 칸은 다시 false로 초기화
    // bfs이기 때문에 한번 방문했을 때 이동 가능한 4가지 방향 모두에 대해 queue에 넣어줌

    public static int bfs(int x, int y, int d) {
        int nx, ny;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, d});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            x = tmp[0];
            y = tmp[1];
            d = tmp[2];
            if (x == n - 1 && y == m - 1) break;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // if (map[nx][ny] == 0) continue;
                if (!map[nx][ny]) continue;
                // 이미 탐색한 칸이고, 방금 탐색한 칸보다 짧게 이동할 수 있는 경로가 있는 칸이라면 탐색하지 않음
                // visited 배열 대신 사용한다 생각하면 됨
                // if (map[nx][ny] != 1 && map[nx][ny] <= map[x][y]) continue;
                map[nx][ny] = false;
                // map[nx][ny] = map[x][y] + 1;
                queue.offer(new int[]{nx, ny, d + 1});
            }

        }
        // return map[n - 1][m - 1];
        return d;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        // map = new int[n][m];
        for (int i = 0; i < n; i++) {
            // 한 글자씩 자르기
            String[] rows = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (rows[j].equals("0")) map[i][j] = false;
                else map[i][j] = true;
                // map[i][j] = Integer.parseInt(rows[j]);
            }
        }

        System.out.println(bfs(0, 0, 1));
    }
}

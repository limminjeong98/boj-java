package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2667
// 단지번호붙이기
public class N2667 {
    static int n;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static List<Integer> ans;

    public static void bfs(int x, int y) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] == true) continue;
                if (map[nx][ny] == 0) continue;
                queue.offer(new int[]{nx, ny});
                // 방문 처리 꼭 해주기
                visited[nx][ny] = true;
            }
//            System.out.println("---");
        }
        ans.add(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                // ascii 코드 값 이용
                // char - char 연산 결과는 int 로 들어감
                map[i][j] = s.charAt(j) - '0';
//                System.out.println(map[i][j]);
            }
        }
        visited = new boolean[n][n];
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}

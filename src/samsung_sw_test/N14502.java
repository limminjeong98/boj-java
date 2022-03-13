package samsung_sw_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/14502
// 연구소
public class N14502 {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] cloned; // 확인할 때 사용하는 복사된 맵
    static List<int[]> viruses;
    static List<int[]> spaces;
    static int sL;
    static int answer;
    static boolean[][] visited;

    public static int bfs(List<int[]> arr) {
        // map을 복사해서 사용
        cloned = new int[n][m];
        for (int i = 0; i < n; i++) {
            cloned[i] = map[i].clone();
        }
        int cnt = 0;
        for (int i = 0; i < arr.size(); i++) {
            // 벽을 빈칸으로 바꿈
            cloned[arr.get(i)[0]][arr.get(i)[1]] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < viruses.size(); i++) {
            queue.offer(new int[]{viruses.get(i)[0], viruses.get(i)[1]});
        }
        int x, y;
        int nx = 0, ny = 0;
        // 확산을 시작할 때마다 visited 방문 배열 초기화 필요
        visited = new boolean[n][m];
        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            x = virus[0];
            y = virus[1];
            // if (visited[x][y]) continue;
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
                // 이미 방문한 장소면 다시 확인할 필요 없음
                if (visited[nx][ny]) continue;
                if (cloned[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    cloned[nx][ny] = 2;
                } else if (cloned[nx][ny] == 2) {
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        // 안전 영역 크기를 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cloned[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int index, int cnt, List<int[]> arr) {
        // 벽을 3개 세웠다면 바이러스를 확산시킴
        if (cnt == 3) {
            int tmp = bfs(arr);
            answer = answer >= tmp ? answer : tmp;
            return;
        }
        if (index == sL) return;
        for (int i = index; i < sL; i++) {
            arr.add(new int[]{spaces.get(i)[0], spaces.get(i)[1]});
            dfs(i + 1, cnt + 1, arr);
            arr.remove(cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        viruses = new ArrayList<>();
        spaces = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                } else if (map[i][j] == 0) {
                    spaces.add(new int[]{i, j});
                }
            }
            // Arrays.fill(map[i], )
        }
        // 0 빈 칸 1 벽 2 바이러스
        // 빈 칸 spaces 중에서 3개에 벽을 세우는 건 dfs
        // viruses에서 확산은 bfs
        sL = spaces.size();
        answer = 0;
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < sL; i++) {
            arr.add(new int[]{spaces.get(i)[0], spaces.get(i)[1]});
            dfs(i + 1, 1, arr);
            arr.remove(0); // 방금 저장한 인덱스에 해당하는 원소를 삭제
        }
        System.out.println(answer);
    }
}

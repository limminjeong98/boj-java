package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1260
// DFS와 BFS
public class N1260 {
    static int map[][];
    static boolean[] visited;
    static int n, m, v;

    // 함수 재귀 호출 (dfs는 stack으로 풀 수도 있다)
    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + 1 + " ");
        for (int nextNode = 0; nextNode < n; nextNode++) {
            if (map[node][nextNode] == 1 && visited[nextNode] == false) {
                dfs(nextNode);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
//        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            System.out.print(curNode + 1 + " ");
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (map[curNode][nextNode] == 1 && visited[nextNode] == false) {
                    // 큐에 다음에 방문할 노드로 넣어준다
                    queue.offer(nextNode);
                    // 방문 처리
                    visited[nextNode] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // 기본 delimeter는 " "임
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 0);
        }
        // 입력으로 주어지는 테스트케이스가 1개면 항상 처음엔 false로 초기화되어 있기는 함
        Arrays.fill(visited, false);
        for (int i = 0; i < m; i++) {
            String edge = br.readLine();
            StringTokenizer st2 = new StringTokenizer(edge, " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            // 양방향으로 이어진 간선
            map[a - 1][b - 1] = map[b - 1][a - 1] = 1;
        }
        dfs(v - 1);
        System.out.println();
        // 방문 처리한 배열을 초기화
        Arrays.fill(visited, false);
        bfs(v - 1);
    }
}

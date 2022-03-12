package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11725
// 트리의 부모 찾기
public class N11725 {
    static int n;
    static int[] parents;
    static ArrayList<Integer>[] arr;

    public static void dfs(int start, int parent) {
        parents[start] = parent;
        for (int node : arr[start]) {
            if (node != parent) dfs(node, start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1번 노드부터 n번 노드까지
        n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st;
        int a, b;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1, 0);
        for (int i = 2; i <= n; i++) System.out.println(parents[i]);
    }
}

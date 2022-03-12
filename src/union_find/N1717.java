package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1717
// 집합의 표현
public class N1717 {
    static int[] parents;

    public static void union(int a, int b) {
        if (findParent(a) > findParent(b)) {
            parents[a] = b;
        } else {
            parents[b] = a;
        }
    }

    public static int findParent(int a) {
        if (parents[a] != a) {
            return findParent(parents[a]);
        }
        return parents[a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        parents = IntStream.range(0, n + 1).toArray();
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 합집합
            String tmp = st.nextToken();

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if ("0".equals(tmp)) {
                union(a, b);
            } else {
                if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

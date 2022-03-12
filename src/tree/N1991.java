package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1991
// 트리 순회
public class N1991 {
    public static String ans = "";
    public static Map<String, List<String>> tree;

    // 전위 순회
    public static void preOrder(String s) {
        if (".".equals(s)) return;
        ans += s;
        // 트리의 왼쪽
        preOrder(tree.get(s).get(0));
        // 트리의 오른쪽
        preOrder(tree.get(s).get(1));
    }

    // 중위 순회
    public static void inOrder(String s) {
        if (".".equals(s)) return;
        // 트리의 왼쪽
        inOrder(tree.get(s).get(0));
        ans += s;
        // 트리의 오른쪽
        inOrder(tree.get(s).get(1));
    }

    // 후위 순회
    public static void postOrder(String s) {
        if (".".equals(s)) return;
        // 트리의 왼쪽
        postOrder(tree.get(s).get(0));
        // 트리의 오른쪽
        postOrder(tree.get(s).get(1));
        ans += s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            List<String> tmp = new ArrayList<>(Arrays.asList(st.nextToken(), st.nextToken()));
            tree.put(node, tmp);
        }
        preOrder("A");
        System.out.println(ans);
        ans = "";
        inOrder("A");
        System.out.println(ans);
        ans = "";
        postOrder("A");
        System.out.println(ans);
    }

}

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11399
// ATM
public class N11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        int tmp = 0;
        int ans = 0;
        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            ans += tmp;
            ans += time[i];
            tmp += time[i];
        }
        System.out.println(ans);
    }
}

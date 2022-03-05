package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1931
// 회의실 배정
public class N1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시각부터 확인
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 끝나는 시각이 같다면 먼저 끝나는 회의를 선택
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                // 같지 않다면 끝나는 시각이 빠른 회의를 선택
                return o1[1] - o2[1];
            }
        });
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(time[i]));
//        }
        // [1, 4] [3, 5] [0, 6] [5, 7] [3, 8] [5, 9] [6, 10] [8, 11] [8, 12] [2, 13] [12, 14]
        // 정렬된 결과는 끝나는 시각이 빠른 순서대로 먼저 정렬되고
        // 끝나는 시각이 같은 회의끼리는 끝나는 시작이 빠른 순서대로 정렬되어 있을 것임
        int ans = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (prev <= time[i][0]) {
                prev = time[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}

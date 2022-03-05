package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1541
// 잃어버린 괄호
public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 괄호를 적절히 쳐서 식의 값을 최소로 만드려면
        // 모두 양수이기 때문에
        // 연산자의 왼쪽 값은 당연히 작을 수록
        // - 오른쪽은 클 수록
        // + 면 오른쪽 작을 수록
        // 즉 +를 먼저 계산해준 뒤에 -를 계산해주면 된다
        // 따라서 -를 기준으로 다른 연산을 묶어서 괄호를 만든다
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int ans = 0;
        // -를 기준으로 만든 괄호 묶음에서
        // 맨 처음 피연산자의 경우는 더해주고
        // 그다음부터는 빼줘야함
        boolean flag = true;
        while (st.hasMoreTokens()) {
            int tmp = 0;
            // -를 기준으로 나눴기 때문에 여기에는 +와 숫자밖에 없음
            StringTokenizer innerSt = new StringTokenizer(st.nextToken(), "+");
            while (innerSt.hasMoreTokens()) {
                tmp += Integer.parseInt(innerSt.nextToken());
            }
            if (flag) {
                ans += tmp;
                flag = false;
            } else {
                ans -= tmp;
            }
        }
        System.out.println(ans);
    }
}

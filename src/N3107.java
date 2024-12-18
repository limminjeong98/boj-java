import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// IPv6
// https://www.acmicpc.net/problem/3107

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // java의 split은 연속된 :를 처리 못함
        if (str.contains("::")) {
            str = str.replace("::", ":*:");
        }

        String[] splits = str.split(":");
        int n = splits.length;

        List<String> answer = new ArrayList<>();

        int index = -1;
        for (int i = 0; i < n; i++) {
            String s = splits[i];
            // System.out.println("i = " + i + ", s = " + s);
            // ::이 맨 앞이나 맨 뒤에 올 경우
            if (s.equals("")) continue;
            if (s.equals("*")) {
                answer.add("0000");
                index = i;
            } else {
                answer.add("0".repeat(4 - s.length()) + s);
            }
        }

        int size = answer.size();
        if (size != 8) {
            int count = 8 - size;
            while (count > 0) {
                answer.add(index, "0000");
                count--;
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s);
            sb.append(":");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}

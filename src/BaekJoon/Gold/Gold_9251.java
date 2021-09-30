package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] LCS = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                    continue;
                }
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);

                if (c1 == c2) {  // 문자가 같다면 LCS[i-1][j-1]값을 찾아 +1
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else{ // 문자가 다르면 LCS[i-1][j] 와 LCS[i][j-1]중에 큰값을 표시
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (max < LCS[i][j]) {
                    max = LCS[i][j];
                }
            }
        }

        System.out.println(max);
    }
}

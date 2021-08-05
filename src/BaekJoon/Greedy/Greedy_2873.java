package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Greedy_2873 {
    static int R, C;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sarr = br.readLine().split(" ");
        R = Integer.parseInt(sarr[0]);
        C = Integer.parseInt(sarr[1]);
        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            sarr = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(sarr[j]);
            }
        }

        StringBuffer buf = new StringBuffer();

        if (R % 2 != 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C - 1; j++) {
                    if (i % 2 == 0)
                        buf.append("R");
                    else
                        buf.append("L");
                }
                if (i < R - 1)
                    buf.append("D");
            }
        }

        else if (R % 2 == 0 && C % 2 != 0) {
            for (int i = 0; i < C; i++) {
                for (int j = 0; j < R - 1; j++) {
                    if (i % 2 == 0)
                        buf.append("D");
                    else
                        buf.append("U");
                }
                if (i < C - 1)
                    buf.append("R");
            }
        }

        else if (R % 2 == 0 && C % 2 == 0) {
            int mr = 0, mc = 0; // 가장 최소 기쁨을 가진 검은타일 위치
            int min = 1001; // 가장 최소 기쁨을 가진 검은타일의 기쁨
            for (int i = 0; i < R; i++) {
                int j;
                if (i % 2 == 0)
                    j = 1;
                else
                    j = 0;
                for (; j < C; j += 2) {
                    if (arr[i][j] < min) {
                        min = arr[i][j];
                        mr = i;
                        mc = j;
                    }
                }
            }

            StringBuffer buf1 = new StringBuffer();
            StringBuffer buf2 = new StringBuffer();
            int sr = 0, sc = 0;
            int er = R - 1, ec = C - 1;

            while (er - sr > 1) {
                if (sr / 2 < mr / 2) {
                    for (int i = 0; i < C - 1; i++)
                        buf1.append("R");
                    buf1.append("D");

                    for (int i = 0; i < C - 1; i++)
                        buf1.append("L");
                    buf1.append("D");
                    sr += 2;
                }
                if (er / 2 > mr / 2) {
                    for (int i = 0; i < C - 1; i++)
                        buf2.append("R");
                    buf2.append("D");

                    for (int i = 0; i < C - 1; i++)
                        buf2.append("L");
                    buf2.append("D");
                    er -= 2;
                }
            }

            while (ec - sc > 1) {
                if (sc / 2 < mc / 2) {
                    buf1.append("D");
                    buf1.append("R");
                    buf1.append("U");
                    buf1.append("R");
                    sc += 2;
                }
                if (ec / 2 > mc / 2) {
                    buf2.append("D");
                    buf2.append("R");
                    buf2.append("U");
                    buf2.append("R");
                    ec -= 2;
                }
            }
            if (mc == sc) {
                buf1.append("R");
                buf1.append("D");
            } else {
                buf1.append("D");
                buf1.append("R");
            }

            buf.append(buf1);
            buf.append(buf2.reverse());

        }
        bw.write(buf.toString() + "\n");
        bw.flush();

    }

}

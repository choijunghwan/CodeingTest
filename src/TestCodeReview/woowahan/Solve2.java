package TestCodeReview.woowahan;

public class Solve2 {

    public String solution(String[] log) {
        int time = 0;

        for (int i = 0; i < log.length; i += 2) {
            int start = StringToTime(log[i]);
            int end = StringToTime(log[i+1]);

            int studyTime = end - start;

            if (studyTime < 5) {
                continue;
            }

            if (studyTime > 105) {
                studyTime = 105;
            }

            time += studyTime;
        }

        return TimeToString(time);
    }

    private String TimeToString(int time) {
        StringBuilder sb = new StringBuilder();

        int HH = time / 60;
        int[] H = new int[2];
        for (int i = H.length - 1; i >= 0; i--) {
            H[i] = HH % 10;
            HH /= 10;
        }

        int MM = time % 60;
        int[] M = new int[2];
        for (int i = M.length - 1; i >= 0; i--) {
            M[i] = MM % 10;
            MM /= 10;
        }

        for (int h : H) {
            sb.append(h);
        }
        sb.append(":");
        for (int m : M) {
            sb.append(m);
        }
        return sb.toString();
    }

    private int StringToTime(String time) {
        int result = 0;
        String[] str = time.split(":");

        result += Integer.parseInt(str[0]) * 60;
        result += Integer.parseInt(str[1]);
        return result;
    }
}

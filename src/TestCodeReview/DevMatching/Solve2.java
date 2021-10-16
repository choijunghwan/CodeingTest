package TestCodeReview.DevMatching;

import java.util.Arrays;

public class Solve2 {
    public static void main(String[] args) {
        int leave = 4;
        String day = "FRI";
        int[] holidays = {6, 21, 23, 27, 28};
        int result = solution(leave, day, holidays);
        System.out.println("result = " + result);
    }

    static int ans = 0;
    public static int solution(int leave, String day, int[] holidays) {

        boolean[] holiday = getWeekend(day);
        for (int i = 0; i < holidays.length; i++) {
            holiday[holidays[i]] = true;
        }


        int isRestDay = 0;
        for (int i = 1; i <= 30; i++) {
            if (holiday[i]) {
                isRestDay++;
            }
        }
        // 연차 > 일할 수 있는 날짜 30일 쉴수있다.
        if (leave >= (30 - isRestDay)) {
            return 30;
        }


        for (int i = 1; i <= 30 - leave; i++) {
            if (!holiday[i]) {
                leaveCnt(i, holiday, leave);
            }
        }


        return ans;
    }

    private static void leaveCnt(int start, boolean[] holiday, int leave) {
        boolean[] restDay = Arrays.copyOf(holiday, holiday.length);
        while (leave > 0) {

            // 휴가를 다 쓰지 못하는 경우
            if (start > 30) {
                return;
            }

            if (restDay[start]) {
                start++;
                continue;
            }


            restDay[start++] = true;
            leave--;
        }

        int count = 0;
        for (int i = 1; i <= 30; i++) {
            if (restDay[i]) {
                for (int j = i; j <= 30; j++) {
                    if (restDay[j]) {
                        count++;
                    } else {
                        i = j - 1;
                        break;
                    }
                }
            }

            ans = Math.max(ans, count);
            count = 0;
        }
    }

    private static boolean[] getWeekend(String day) {
        boolean[] holiday = new boolean[31];
        //일 -> 1,7 월 -> 6,7 화 -> 5,6 수 -> 4,5 목 -> 3,4 금 -> 2,3 토 -> 1,2

        int first = 0;
        int second = 0;
        if (day.equals("MON")) {
            first = 6;
            second = 7;
        } else if (day.equals("TUE")) {
            first = 5;
            second = 6;
        } else if (day.equals("WED")) {
            first = 4;
            second = 5;
        } else if (day.equals("THU")) {
            first = 3;
            second = 4;
        } else if (day.equals("FRI")) {
            first = 2;
            second = 3;
        } else if (day.equals("SAT")) {
            first = 1;
            second = 2;
        } else if (day.equals("SUN")) {
            first = 1;
            second = 7;
        }

        while(first < 30) {
            holiday[first] = true;
            first += 7;
        }
        while(second < 30) {
            holiday[second] = true;
            second += 7;
        }

        return holiday;
    }
}

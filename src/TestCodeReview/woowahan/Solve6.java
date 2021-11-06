package TestCodeReview.woowahan;

public class Solve6 {

    public static void main(String[] args) {
        double time = 3.5;
        String[][] plans = {{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}};

        String result = solution(time, plans);
    }
    public static String solution(double time, String[][] plans) {
        String lastTravel = "";

        for (String[] plan : plans) {

            double friTime = stringToTime(plan[1]);
            double monTime = stringToTime(plan[2]);

            if (friTime < 18) {  //퇴근 시간보다 일찍 출발
                if (friTime > 9.5) {  // 출근 시간보다 늦게 출발
                    time -= (18 - friTime);
                } else {
                    time -= 8.5;
                }
            }

            if (monTime > 13) {
                if (monTime < 18) {
                    time -= (18 - monTime);
                } else {
                    time -= 5;
                }
            }

            if (time < 0) {
                break;
            }

            lastTravel = plan[0];
        }


        return lastTravel;
    }

    private static double stringToTime(String time) {
        String clock = time.substring(0, time.length() -2);
        String light = time.substring(time.length() -2, time.length());

        double planTime = 0;
        planTime += Double.parseDouble(clock);

        if (light.equals("PM")) {
            planTime += 12;
        }
        return planTime;
    }
}

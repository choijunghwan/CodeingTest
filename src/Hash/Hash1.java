package Hash;
import java.util.ArrayList;
import java.util.Arrays;

public class Hash1 {
    public static void main(String[] args) {

        /*int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        ArrayList answers = new ArrayList();

        System.out.println(commands.length);

        for(int i = 0; i < commands.length; i++){
            int[] tmp = Arrays.copyOfRange(array,commands[i][0] - 1, commands[i][1] );
            Arrays.sort(tmp);
            answers.add(tmp[(commands[i][2] - 1)]);
        }

        System.out.println("answers = " + answers);
        int[] arr = new int[answers.size()];
        for(int i = 0; i < answers.size(); i++){
            arr[i] = (int) answers.get(i);
        }*/

        /*int[] answers = {1, 2, 3, 4, 5};

        int correct_1 = 0;
        int correct_2 = 0;
        int correct_3 = 0;

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            int tmp1 = i % 5;
            int tmp2 = i % 8;
            int tmp3 = i % 10;

            if (answers[tmp1] == one[tmp1]) {
                correct_1++;
            }
            if (answers[tmp2] == two[tmp2]) {
                correct_2++;
            }
            if (answers[tmp3] == three[tmp3]) {
                correct_3++;
            }
        }
        System.out.println("correct_1 = " + correct_1);
        System.out.println("correct_2 = " + correct_2);
        System.out.println("correct_3 = " + correct_3);

        int[] count = {correct_1, correct_2, correct_3};
        ArrayList correct = new ArrayList();

        int max = 0;

        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }

        for (int i = 0; i < count.length; i++){
            if (max == count[i]) {
                correct.add(i + 1);
            }
        }

        int[] arr = new int[correct.size()];
        for(int i = 0; i < correct.size(); i++){
            arr[i] = (int) correct.get(i);
        }
        Arrays.sort(arr);

        System.out.println("arr = " + arr);*/

        String new_id = "...!@BaT#*..y.abcdefghijklm";

        // 1단계 모든 대문자는 소문자로 변화
        new_id = new_id.toLowerCase();
        System.out.println("new_id = " + new_id);

        // 2단계 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자를 모두 제거
        new_id = new_id.replaceAll("[~!@#$%^&*()=+[{]}:?,<>]", "");
        System.out.println("new_id = " + new_id);

        // 3단계 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        new_id = new_id.replaceAll("[.]{2,}", ".");
        System.out.println("new_id = " + new_id);

        // 4단계 아이디의 처음, 끝에 위치한 마침표(.) 제거
        String[] array_id;
        array_id = new_id.split("");
        System.out.println("array_id = " + Arrays.toString(array_id));
        if(array_id[array_id.length -1].equals(".")){
            if(array_id.length == 1){
                String[] tmp = {"a","a","a"};
                array_id = Arrays.copyOfRange(tmp, 0, 3);
            }
            else {
                array_id = Arrays.copyOfRange(array_id, 0,array_id.length - 1);
            }
        }
        System.out.println("array_id = " + Arrays.toString(array_id));
        if (array_id[0].equals(".")) {
            if(array_id.length == 1){
                String[] tmp = {"a","a","a"};
                array_id = Arrays.copyOfRange(tmp, 0, 3);
            }
            else {
                array_id = Arrays.copyOfRange(array_id, 1,array_id.length - 1);
            }
        }
        System.out.println("array_id = " + Arrays.toString(array_id));

        // 6단계 길이가 16자 이상이면
        if (array_id.length >= 16) {
            array_id = Arrays.copyOfRange(array_id, 0, 15);
            System.out.println("array_id = " + Arrays.toString(array_id));
            if(array_id[array_id.length -1].equals(".")){
                array_id = Arrays.copyOfRange(array_id, 0,array_id.length - 1);
            }
            System.out.println("array_id = " + Arrays.toString(array_id));
            if (array_id[0].equals(".")) {
                array_id = Arrays.copyOfRange(array_id, 1, array_id.length);
            }
            System.out.println("array_id = " + Arrays.toString(array_id));
        }
        else if (array_id.length <= 2){
            if (array_id.length == 1) {
                String[] arr = new String[3];
                arr[0] = array_id[0];
                arr[1] = array_id[0];
                arr[2] = array_id[0];
                array_id = Arrays.copyOfRange(arr, 0, arr.length);
            } else if (array_id.length == 2) {
                String[] arr = new String[3];
                arr[0] = array_id[0];
                arr[1] = array_id[1];
                arr[2] = array_id[1];
                array_id = Arrays.copyOfRange(arr, 0, arr.length);
            }

        }

        String str = new String();
        for(int i = 0; i < array_id.length; i++){
            str = String.join("", array_id);
        }

//        return str;

        /*String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        String[][] table = new String[info.length][];

        for (int i = 0; i < info.length; i++) {
            String[] tmp = info[i].split(" ");
            table[i] = Arrays.copyOf(tmp, tmp.length);
        }

        *//*for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]); // 열 출력
            }
            System.out.println(); // 행 출력
        }*//*

        int count = 0;
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] tmp = query[i].split(" ");
            for (int j = 0; j < table.length; j++) {
                if (tmp[0].equals("-") || tmp[0].equals(table[j][0])) { // 언어가 같은지 체크
                    if (tmp[2].equals("-") || tmp[2].equals(table[j][1])) { // 직군이 같은지 체크
                        if(tmp[4].equals("-") || tmp[4].equals(table[j][2])){  // 경력이 같은지 체크
                            if(tmp[6].equals("-") || tmp[6].equals(table[j][3])){  // 소울 푸드 체크
                                int num1 = Integer.parseInt(tmp[7]);
                                int num2 = Integer.parseInt(table[j][4]);
                                if (num1 <= num2) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = count;
            count = 0;
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));*/

        /*
        * 1. log 기록된 시작시간 마다 누적 재생시간을 계산해서 max 값을 구한다.*/

        /*String play_time = "02:03:55";

        String adv_time = "00:14:15";
        String[] adv_time_arr = adv_time.split(":");
        Integer[] int_adv_time_arr = new Integer[3];
        for (int i = 0; i < adv_time_arr.length; i++) {
            int_adv_time_arr[i] = Integer.parseInt(adv_time_arr[i]);
        }
        System.out.println("Arrays.toString(adv_time_arr) = " + Arrays.toString(adv_time_arr));

        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String[][] table = new String[logs.length][6];
        for (int i = 0; i < logs.length; i++) {
            String[] tmp = logs[i].split("-");
            String[] arr1 = tmp[0].split(":");
            String[] arr2 = tmp[1].split(":");
            System.arraycopy(arr1, 0, table[i], 0, arr1.length);
            System.arraycopy(arr2, 0, table[i], arr1.length, arr2.length);
        }

        Integer[][] int_table = new Integer[table.length][6];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                int_table[i][j] = Integer.parseInt(table[i][j]);
            }
        }

        Integer[] watch_time = new Integer[logs.length];

        for (int i = 0; i < table.length; i++) {


        }*/



    }
    /*public Integer[] time_sum(Integer[] int_adv_time_arr, Integer[][] int_table){
        Integer[] finish_time = new Integer[3];
        for (int i = 0; i < 3; i++) {
            if (int_table[i][2] + int_adv_time_arr[2] >= 60) {
                finish_time[2] = int_table[i][2] + int_adv_time_arr[2] - 60;
                if(int_table[i][1] + int_adv_time_arr[1] >= 59){
                    finish_time[1] = int_table[i][1] + int_adv_time_arr[1] - 59;
                    finish_time[0] = int_table[i][0] + int_adv_time_arr[0] + 1;
                }
                else{
                    finish_time[1] = int_table[i][1] + int_adv_time_arr[1] + 1;
                    finish_time[0] = int_table[i][0] + int_adv_time_arr[0];
                }
            }
            else{
                finish_time[2] = int_table[i][2] + int_adv_time_arr[2];
                if(int_table[i][1] + int_adv_time_arr[1] >= 60){
                    finish_time[1] = int_table[i][1] + int_adv_time_arr[1] - 60;
                    finish_time[0] = int_table[i][0] + int_adv_time_arr[0] + 1;
                }
                else{
                    finish_time[1] = int_table[i][1] + int_adv_time_arr[1];
                    finish_time[0] = int_table[i][0] + int_adv_time_arr[0];
                }
            }
        }
        return finish_time;
    }
*/

}


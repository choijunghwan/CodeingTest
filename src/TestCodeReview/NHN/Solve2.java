package TestCodeReview.NHN;

import java.util.Arrays;
import java.util.Scanner;

public class Solve2 {
    public static void main(String[] args) throws Exception{
        InputData inputData = processStdin();

        int numOfRegion = 4;
        int numOfAttackableFrequency = 3;
        int[][] frequencies = {{6, 18, 16, 17, 2, 9, 19}, {8, 2, 16, 3, 11, 6, 19, 15, 17}, {5, 19, 1, 4, 17, 7}, {6, 16, 3, 6, 19, 14, 12}};
        solution(numOfRegion, numOfAttackableFrequency, frequencies);
    }

    private static void solution(int numOfRegion, int numOfAttackableFrequency, int[][] frequencies) {
        int[] map = new int[21];

        for (int i = 0; i < numOfRegion; i++) {
            for (int j = 0; j < frequencies[i].length; j++) {
                map[frequencies[i][j]]++;
            }
        }
        Arrays.sort(map);

        int sum = 0;
        for (int i = 1; i <= numOfAttackableFrequency; i++) {
            sum += map[21 - i];
        }
        System.out.println(sum);

    }

    private static class InputData {
        int numOfRegion;
        int numOfAttackableFrequency;
        int[][] frequencies;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            String[] temp = scanner.nextLine().split(" ");
            inputData.numOfRegion = Integer.parseInt(temp[0]);
            inputData.numOfAttackableFrequency = Integer.parseInt(temp[1]);
            inputData.frequencies = new int[inputData.numOfRegion][];

            for (int i = 0; i < inputData.numOfRegion; i++) {
                temp = scanner.nextLine().split(" ");

                int numOfFrequency = Integer.valueOf(temp[0]);
                inputData.frequencies[i] = new int[numOfFrequency];
                for (int j = 0; j < numOfFrequency; j++) {
                    inputData.frequencies[i][j] = Integer.parseInt(temp[j + 1]);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return inputData;
    }
}

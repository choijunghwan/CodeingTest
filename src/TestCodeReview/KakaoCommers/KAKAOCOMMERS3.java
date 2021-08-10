package TestCodeReview.KakaoCommers;

public class KAKAOCOMMERS3 {
    public static void main(String[] args) {
        int n =6;
        int[] passenger = {1, 1, 1, 1, 1, 1};
        int[][] train = {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};

        int[][] Dist = new int[n][n];
        int[][] PassengerCount = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Dist[i][j] = 0;
                PassengerCount[i][j] = 0;
            }
        }

        for (int i = 0; i < train.length; i++) {
            Dist[train[i][0] - 1][train[i][1] - 1] = 1;
            Dist[train[i][1] - 1][train[i][0] - 1] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Dist[i][k] == 1 && Dist[k][j] == 1) {
                        PassengerCount[i][j] = PassengerCount[i][k] + passenger[j];
                    }
                }
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Dist[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(PassengerCount[i][j]);
            }
            System.out.println();
        }
    }
}

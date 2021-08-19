package Programmers.WeeklyChallenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solve3 {
    public static void main(String[] args) {

        int[][] game_board = {{1,1,0,0,1,0},
                {0,0,1,0,1,0},
                {0,1,1,0,0,1},
                {1,1,0,1,1,1},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0}
        };

        int[][] table = {{1,0,0,1,1,0},
                {1,0,1,0,1,0},
                {0,1,1,0,1,1},
                {0,0,1,0,0,0},
                {1,1,0,1,1,0},
                {0,1,0,0,0,0}
        };

        /*int[][] game_board = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int[][] table = {{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};*/

        int result = solution(game_board, table);
        System.out.println("result = " + result);
    }
    // game_board를 돌면서 빈공간이 나오면 빈공간에 맞는 퍼즐조각을 table에서 찾는다.

    // 빈공간이 있으면 table에서 존재하는 조각들과 일일이 비교한다.
    // 비교할때 조각을 0, 90, 180, 270 회전한 경우를 모두 대조해본다.
    // 만약 대조해 조각이 일치하면 채워준다.
    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                if (game_board[i][j] == 0) {
                    // 게임 보드의 퍼즐 조각을 찾아 반환.
                    int[][] puzzle = bfsBoard(game_board, i, j);

                    answer += searchPuzzle(puzzle, table);
                }
            }
        }

        return answer;
    }

    // (x,y) (y,-x) (-x,-y) (-y,x)
    private static int[][] rotatePuzzle(int[][] puzzle, int k) {
        if (k == 0) {
            return puzzle;
        }

        int[][] rotate = new int[puzzle.length][2];

        // 90도 회전
        if (k == 1){
            for (int i = 0; i < puzzle.length; i++) {
                int x = puzzle[i][0];
                int y = puzzle[i][1];
                rotate[i][0] = y;
                rotate[i][1] = -x;
            }
        }

        // 180도 회전
        if (k == 2){
            for (int i = 0; i < puzzle.length; i++) {
                int x = puzzle[i][0];
                int y = puzzle[i][1];
                rotate[i][0] = -x;
                rotate[i][1] = -y;
            }
        }

        // 270도 회전
        if (k == 3){
            for (int i = 0; i < puzzle.length; i++) {
                int x = puzzle[i][0];
                int y = puzzle[i][1];
                rotate[i][0] = -y;
                rotate[i][1] = x;
            }
        }

        return rotate;
    }

    private static int searchPuzzle(int[][] puzzle, int[][] table) {
        int count = 0;
        int len = table.length;

        for (int k = 0; k < 4; k++) {
            int[][] resultPuzzle = rotatePuzzle(puzzle, k);
            int[][] serveTable = new int[len][len];
            for (int i = 0; i < len; i++) {
                serveTable[i] = Arrays.copyOf(table[i], len);
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (serveTable[i][j] == 1) {
                        int[][] tablePuzzle = bfsTable(serveTable, i, j);

                        if (resultPuzzle.length == tablePuzzle.length) {
                            for (int[] tp : tablePuzzle) {
                                serveTable[i + tp[0]][j + tp[1]] = 1;
                            }
                        } else {
                            continue;
                        }

                        boolean check = true;
                        for (int[] tp : resultPuzzle) {
                            int nextX = i + tp[0];
                            int nextY = j + tp[1];
                            if (nextX >= 0 && nextX < len && nextY >= 0 && nextY < len) {
                                if (serveTable[i + tp[0]][j + tp[1]] != 1) {
                                    check = false;
                                    break;
                                }
                            } else {
                                check = false;
                                break;
                            }

                        }

                        if (check) {
                            count += tablePuzzle.length;
                            for (int[] tp : tablePuzzle) {
                                table[i + tp[0]][j + tp[1]] = 0;
                            }
                            return count;
                        }

                    }
                }
            }
        }

        return count;
    }

    private static int[][] bfsTable(int[][] serveTable, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[][] locationPoint = new int[6][2];
        int size = 1;

        queue.add(new Point(row, col));

        locationPoint[0][0] = 0;
        locationPoint[0][1] = 0;

        serveTable[row][col] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX >= 0 && nextX < serveTable.length && nextY >= 0 && nextY < serveTable.length) {
                    if (serveTable[nextX][nextY] == 1) {
                        queue.add(new Point(nextX, nextY));
                        serveTable[nextX][nextY] = 0;

                        locationPoint[size][0] = nextX - row;
                        locationPoint[size][1] = nextY - col;
                        size++;
                    }
                }
            }
        }

        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i][0] = locationPoint[i][0];
            result[i][1] = locationPoint[i][1];
        }
        return result;
    }

    private static int[][] bfsBoard(int[][] game_board, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[][] locationPoint = new int[6][2];
        int size = 1;

        queue.add(new Point(row, col));

        locationPoint[0][0] = 0;
        locationPoint[0][1] = 0;

        game_board[row][col] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX >= 0 && nextX < game_board.length && nextY >= 0 && nextY < game_board.length) {
                    if (game_board[nextX][nextY] == 0) {
                        queue.add(new Point(nextX, nextY));
                        game_board[nextX][nextY] = 1;

                        locationPoint[size][0] = nextX - row;
                        locationPoint[size][1] = nextY - col;
                        size++;
                    }
                }
            }
        }

        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i][0] = locationPoint[i][0];
            result[i][1] = locationPoint[i][1];
        }
        return result;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

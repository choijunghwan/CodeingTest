import QUEUE.Queue4;

public class Main {
    public static void main(String[] args) {

        Queue4 queue4 = new Queue4();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        // 3 2 2 1
        int solution = queue4.solution(priorities, location);
        System.out.println("solution = " + solution);


    }
}

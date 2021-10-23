package TestCodeReview.NHN;

import java.util.*;

public class Solve1 {

    public static void main(String[] args) throws Exception{
        InputData inputData = processStdin();

        solution(inputData.numOfOperation, inputData.operations);
    }

    private static void solution(int numOfOperation, Operation[] operations) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 2; i <= numOfOperation; i++) {
            pq.add(i);
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (Operation op : operations) {
            if (op.type == OperationType.branch) {
                int num = pq.poll();
                list.add(num);
            } else if (op.type == OperationType.merge) {
                list.remove(Integer.valueOf(op.value));
                pq.add(op.value);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int namu : list) {
            sb.append(namu);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static class InputData {
        int numOfOperation;
        Operation[] operations;
    }

    private static class Operation {
        OperationType type;
        Integer value;

        public Operation(OperationType type, Integer value) {
            this.type = type;
            this.value = value;
        }
    }

    private static enum OperationType {
        branch,
        merge;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOperation = Integer.parseInt(scanner.nextLine());
            inputData.operations = new Operation[inputData.numOfOperation];

            for (int i = 0; i < inputData.numOfOperation; i++) {
                String[] temp = scanner.nextLine().split(" ");

                Integer value = null;
                OperationType operationType = OperationType.valueOf(temp[0]);
                if (OperationType.merge == operationType) {
                    value = Integer.valueOf(temp[1]);
                }

                inputData.operations[i] = new Operation(operationType, value);
            }
        } catch (Exception e) {
            throw e;
        }
        return inputData;
    }
}

package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        List<Integer> bridge_pass = new ArrayList<>();

        int truck_index = 0;
        int bridge_weigh = 0;
        while (true) {

            if (bridge_pass.size() == truck_weights.length) {
                break;
            }

            Integer temp = bridge.poll();
            if (temp != 0) {
                bridge_weigh -= temp;
                bridge_pass.add(temp);
            }


            if (truck_index < truck_weights.length ) {
                if (bridge_weigh + truck_weights[truck_index] <= weight) {
                    bridge.offer(truck_weights[truck_index]);
                    bridge_weigh += truck_weights[truck_index];
                    truck_index++;
                } else {
                    bridge.offer(0);
                }
            } else {
                bridge.offer(0);
            }

            answer++;

        }

        System.out.println("answer = " + answer);
    }
}

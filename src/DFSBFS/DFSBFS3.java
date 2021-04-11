package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS3 {


    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = 0;
        int check = 0;

        boolean[] visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            visited[i] = false;
            if (target.equals(words[i])) {
                check++;
            }
        }

        if (check <= 0) {
//            return 0;
        }


        Queue<Group> queue = new LinkedList<Group>();
        int depth = 0;

        queue.offer(new Group(begin, depth));

        while (!queue.isEmpty()) {
            Group g = queue.poll();

            if (target.equals(g.word)){
                answer = g.depth;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                int count = 0;

                if (visited[i]) continue;

                for (int j = 0; j < begin.length(); j++) {
                    if (g.word.charAt(j) == words[i].charAt(j)) {
                        count++;
                    }
                }

                if (count == begin.length() - 1) {
                    queue.add(new Group(words[i], g.depth +1));
                    visited[i] = true;
                }
            }

        }

        System.out.println("answer = " + answer);
    }


}

class Group {
    String word;
    int depth;

    Group(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}

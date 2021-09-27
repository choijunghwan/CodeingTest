package Programmers.Heap;

public class Heap {

    public static void heapsort(int[] arr) {
        int size = arr.length;

        /**
         * 부모노드와 heapify과정에서 음수가 발생하면 잘못 된 참조가 발생하기 때문에
         * 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없으므로 바로 함수를 종료한다.
         */
        if (size < 2) {
            return;
        }

        // 가장 마지막 노드의 부모 노드 인덱스
        int parentIdx = getParent(size - 1);

        // max heap 만들기
        for (int i = parentIdx; i >= 0 ; i--) {

            // 부모노드(i값)을 1씩 줄이면서 heap 조건을 만족시키도록 재구성한다.
            heapify(arr, i, size - 1);

        }

        // 정렬 과정
        for (int i = size - 1; i > 0; i--) {

            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }


    //부모 인덱스를 얻는 함수
    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    // 두 인덱스의 원소를 교환하는 함수
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 힙을 만드는 함수
    private static void heapify(int[] a, int parentIdx, int lastIdx) {

        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while ((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = 2 * parentIdx + 1;
            rightChildIdx = 2 * parentIdx + 2;
            largestIdx = parentIdx;


            /**
             * left child node와 비교
             */
            if (a[largestIdx] < a[leftChildIdx]) {
                largestIdx = leftChildIdx;
            }

            /**
             * right child node와 비교
             */
            if (a[largestIdx] < a[rightChildIdx]) {
                largestIdx = rightChildIdx;
            }

            /**
             * 교환이 발생했을 경우 두 원소를 교체 한 후
             * 교환이 된 자식노드를 부모 노드가 되도록 교체한다.
             */
            if (parentIdx != largestIdx) {
                swap(a, largestIdx, parentIdx);
                parentIdx = largestIdx;
            } else {
                return;
            }
        }

    }
}

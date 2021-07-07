package Sort;

public class QuickSort_N {
    static int[] arr;
    static final int N = 4;


    public static void main(String[] args) {
        arr = new int[]{20, 70, 40, 30, 10, 50, 80};


        quicksort(0, arr.length - 1);

        System.out.println(arr[N-1]);
    }

    private static void quicksort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pi = partition(start, end);

        if (pi + 1 == N) {
            return;
        } else if (pi + 1 < N) {
            quicksort(pi + 1, end);
        } else if (pi + 1 > N) {
            quicksort(start, pi - 1);
        }
    }

    private static int partition(int start, int end) {
        // 피벗을 중간요소로 정한 이유는
        // quickSort의 경우 최악의 경우에 O(n^2)의 시간복잡도가 걸리는데
        // 최악의 경우는 모든 요소들이 역순으로 존재했을 경우이다.
        // 이러한 최악의 경우를 피하기 위해서 피봇을 중간요소로 선택하여 문제를 해결할 수 있다.
        int mid = (start + end) / 2;
        int pivot = arr[mid];
        int i = start, j = end;

        swap(start, mid);

        while (i < j) {
            while (pivot < arr[j]) {
                j--;
            }
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            swap(i, j);
        }
        swap(start, i);

        return i;
    }

    private static void swap(int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

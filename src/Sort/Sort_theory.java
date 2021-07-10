package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort_theory {
    public static void main(String[] args) {

        // Array 오름차순 정렬
        int[] arr1 = {5, 7, 19, 2, 15};          //Primitive Type
        String[] stringArr1 = {"A", "C", "F", "E", "D"};

        Arrays.sort(arr1);
        System.out.println("arr1 : " + Arrays.toString(arr1));

        Arrays.sort(stringArr1);
        System.out.println("stringArr1 : " + Arrays.toString(stringArr1));



        // 내림차순을 할때는
        // 1. Comparable 인터페이스의 compareTo() 메서드를 원하는 조건으로 오버라이드
        // 2. Comparator를 구현한 class내 compare() 메서드를 원하는 정렬조건으로 오버라이드하여 sort한다.
        // Comparable / Comparator 는 byte,char,double,short,long,int,float 같은 PrimitiveType 배열에는 적용이 불가능하다
        // Integer, String 같은 Wrapper "Class"를 이용해야 한다.

        Integer[] arr2 = {5, 7, 19, 2, 15};
        Integer[] arr2_lambda = {5, 7, 19, 2, 15};
        String[] stringArr2 = {"A", "C", "F", "E", "D"};
        String[] stringArr3 = {"A", "C", "F", "E", "D"};
        String[] stringArr4 = {"A", "C", "F", "E", "D"};

        Arrays.sort(arr2, Comparator.reverseOrder());
        // Lambda
        Arrays.sort(arr2_lambda, (i1, i2) -> i2 - i1);

        System.out.println("arr2 : " + Arrays.toString(arr2));
        System.out.println("arr2_lambda : " + Arrays.toString(arr2_lambda));

        Arrays.sort(stringArr2, Collections.reverseOrder());
        System.out.println("stringArr2 : " + Arrays.toString(stringArr2));

        // Comparator 인터페이스를 직접 구현해서 적용
        Arrays.sort(stringArr3, new CustomComparator());
        System.out.println("stringArr3 : " + Arrays.toString(stringArr3));

        // Comparator 구현 클래스 정의 없이 Comparator 인스턴스 생성과 동시에 compare() 메서드를 오버라이드
        Arrays.sort(stringArr4, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);   //내림차순
            }
        });
        System.out.println("stringArr4 : " + Arrays.toString(stringArr4));



        String str = "ACBED";

        String[] stringArr5 = str.split("");  // new String[] {"A","C","F","E","D"} 배열로 변환

        String streamSortASC = Stream.of(stringArr5).sorted().collect(Collectors.joining());  //오름차순
        String streamSortDESC = Stream.of(stringArr5).sorted(Comparator.reverseOrder()).collect(Collectors.joining());  // 내림차순
        //Lambda
        String streamSortASC_Lambda = Stream.of(stringArr5).sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.joining());  // 오름차순
        String streamSortDESC_Lambda = Stream.of(stringArr5).sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.joining()); // 내림차순

        System.out.println("streamSortASC = " + streamSortASC);
        System.out.println("streamSortDESC = " + streamSortDESC);
        System.out.println("streamSortASC_Lambda = " + streamSortASC_Lambda);
        System.out.println("streamSortDESC_Lambda = " + streamSortDESC_Lambda);


        // 2차원 배열 정렬
        int[][] arr3 = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};

        Arrays.sort(arr3);
        for (int[] arr : arr3){
            System.out.println(arr[0] + " " + arr[1]);
        }

        // 오름차순
        Arrays.sort(arr3, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        for (int[] arr : arr3){
            System.out.println(arr[0] + " " + arr[1]);
        }

        int[][] arr4 = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        Arrays.sort(arr4, (a,b) -> Integer.compare(a[0],b[0]));

        for (int[] arr : arr4){
            System.out.println(arr[0] + " " + arr[1]);
        }

        // 객체 정렬
        Fruit[] fruits = {
                new Fruit("Apple", 100),
                new Fruit("Kiwi", 500),
                new Fruit("Orange", 200),
                new Fruit("Banana", 50),
                new Fruit("Watermelon", 880),
                new Fruit("Cherry", 10),
        };

        // Fruit 클래스 안에 Comparable을 구현하여 정렬
        Arrays.sort(fruits);

        System.out.println("Sorted fruits[] : " + Arrays.toString(fruits));
    }

}

class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);   //내림차순
    }
}

class Fruit implements Comparable<Fruit> {
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "{name: " + name + ", price: " + price + "}";
    }

    @Override
    public int compareTo(Fruit o) {
        return this.price - o.price;
    }
}

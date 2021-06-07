package Codeup;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Codeup {
    public static void main(String[] args) {
        System.out.println("Hello");  //1001
        System.out.println("Hello World"); //1002
        System.out.println("Hello\nWorld");  //1003
        System.out.println("'Hello'"); //1004
        System.out.println("\"Hello World\" ");  //1005
        System.out.println("\"!@#$%^&*()\"");  //1006
        System.out.println("\"C:\\Download\\hello.cpp\"");  //1007
        System.out.println("\u250C\u252C\u2510");
        System.out.println("\u251C\u253C\u2524");
        System.out.println("\u2514\u2534\u2518");  //1008

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String octalnum = Integer.toOctalString(num);  //10진수 -> 8진수
        String hexnum = Integer.toHexString(num);  //10진수 -> 16진수
        String hexNum = String.format("%X", num);  //10진수 -> 16진수 %X 대문자, %x 소문자

        String octalNum = sc.nextLine();
        //8진수 -> 10진수
        //Integer.parseInt(문자열, 원하는 진수)
        int num1 = Integer.parseInt(octalNum, 8);
        int num2 = Integer.parseInt(octalNum, 16);

        char word = sc.next().charAt(0);
        System.out.println((int)word);

        int num4 = sc.nextInt();
        System.out.println((char)num4);

        char word1 = sc.next().charAt(0);
        System.out.println((char)(word+1));

        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);

        String s = sc.nextLine();
        StringTokenizer st1 = new StringTokenizer(s, " ");
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        System.out.println(a1<<b1);

        //비트연산자 NOT ~  ,  AND &  , or |  , xor ^

        //float형 둘째자리까지 출력
        //System.out.format("%.1f MB", result);
    }

}

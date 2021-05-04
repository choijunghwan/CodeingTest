package KAKAO;

public class KAKAO_2020_2 {
    public static void main(String[] args) {
        String p = ")(";

        String answer = solution(p);
        System.out.println("answer = " + answer);
    }

    public static String solution(String p) {
        String result = "";


        return sep(p, result);
    }

    public static String sep(String s, String result) {
        String u = new String();
        String v = new String();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ++count;
            } else if (s.charAt(i) == ')') {
                --count;
            }

            if (count == 0) {
                u = s.substring(0, i+1);
                v = s.substring(i+1, s.length());
                break;
            }
        }

        for (int i = 0; i < u.length(); i++){
            if (u.charAt(i) == '(') {
                ++count;
            } else if (u.charAt(i) == ')') {
                --count;
            }

            if (count < 0){
                u = convert(u);
                break;
            }
        }
        result += u;

        if (v.isEmpty()) {
            return result;
        } else {
            result = sep(v,result);
        }

        return result;

    }

    public static String convert(String q) {

        q.replace("(", ".");
        q.replace(")", "(");
        q.replace(".", ")");

        String str = "(";
        str.concat(q.substring(1,q.length()-1));
        str.concat(")");
        return str;
    }
}

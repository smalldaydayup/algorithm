package sword;

public class ReplaceSpace {
    public static void main(String[] args) {
        String obj = "We are happy";
        System.out.println(solution(obj));
    }

    public static String solution(String str) {
        return str.replace(" ", "%20");
    }
}

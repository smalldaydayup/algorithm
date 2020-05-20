package utils;


import java.util.Scanner;

public class Buidler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = 0;

        try {
            num = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            System.out.println("ERROR");
            return;
        }

        if (isCopy(num)) {
            System.out.println(num);
            return;
        }

        for (int i = 1; i < num; i++) {
            int n1 = num - i;
            int n2 = num + i;
            if (isCopy(n1) != true && isCopy(n2) != true) {

            } else {
                if (isCopy(n1)) {
                    System.out.println(n1);
                }

                if (isCopy(n2)) {
                    System.out.println(n2);
                }

                return;
            }
        }

        System.out.println("ERROR");

    }

    public static boolean isCopy(int num) {
        String s = String.valueOf(num);
        StringBuffer sb = new StringBuffer(s);
        String rev = sb.reverse().toString();
        return s.equals(rev);
    }
}


class People {
    String name;
    public People() {
        System.out.println(1);
    }

    public People(String name) {
        System.out.println(2);
        this.name = name;
    }


}


class  Child  extends People {
    People father;

    public Child(String name) {
        System.out.println(3);
        this.name = name;
        father = new People(name + "F");
    }

    public Child() {
        System.out.println(4);
    }
}




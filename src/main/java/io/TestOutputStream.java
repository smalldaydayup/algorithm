package io;

import java.io.*;

public class TestOutputStream {
    public static void main(String[] args) throws IOException {
//        char c;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符， 已 q 退出");
//
//        do {
//            c = (char) br.read();
//            System.out.println(c);
//        } while (c != 'q');

        File f = new File("/Users/kunzhang/work/algorithm/src/main/java/tmp/io.txt");

        if (f.exists()) {
            System.out.println(f.length());
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        boolean flag = true;
        while (flag) {
            String s = reader.readLine();
            if (s == null) {
                flag = false;
            } else {
                System.out.println( s );
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
        writer.newLine();
//        writer.write("love lsy");
        writer.append("sun ping");
//        writer.newLine();
//        writer.write("assafasfasdf");

//        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
//        writer.append("asdsadas");

        reader.close();
        writer.close();

    }
}

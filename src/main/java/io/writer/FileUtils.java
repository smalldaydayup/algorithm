package io.writer;

import java.io.*;

public class FileUtils {
    public static void main(String[] args) throws IOException {
        File file = new File("tmp/text1" );
        System.out.println(file.length());

        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String s = "";
        while ((s = bufferedReader.readLine()) != null){
            System.out.println(s);
        }
        char[] c = new char[10];
        int t =reader.read(c, 0, 10);

        System.out.println(new String(c));
        System.out.println(FileUtils.readStr(file));
    }

    public static void writeStr(File f, String s) throws IOException {
        FileWriter writer = new FileWriter(f, true);
        for (int i = 0; i < 5; i++) {
            writer.write(s);
            writer.write("\r");
        }
        writer.close();
    }

    public static String readStr(File f) throws IOException {
        FileReader reader = new FileReader(f);

        long len = f.length();
        int num = 5;
        int per = ((int)len / num);

        String str = "";
        for (int i = 0; i < num; i++) {
            char[] c = new char[10];
            int offset = i * per;
            reader.read(c, offset, per);
            String s = new String(c);
            System.out.println(s);
            str += s;
        }
        reader.close();
        return  str;
    }
}

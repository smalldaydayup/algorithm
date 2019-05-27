package io;

import java.io.*;
import java.util.stream.Stream;

public class ReillyOutputStream {
    public  static void generateCharacters(OutputStream out) throws IOException {
        int first = 33;
        int number = 94;
        int perLine = 72;

        int start = first;
        while (true) {
            for (int i = 0; i < start + perLine; i++) {
                out.write(((i - first) % number + first));
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - first) % number + first;
        }

    }

    public static void main(String[] args) throws IOException {
        StringReader s = new StringReader("asdasdasdas");
        BufferedReader ne  = new BufferedReader(s);
        int  p = s.read();
        System.out.println((char)p);
//        FileOutputStream writer = new FileOutputStream("ttl");
//        generateCharacters(writer);
//        writer.flush();
//        writer.close();

        ne.close();
        s.close();

    }
}

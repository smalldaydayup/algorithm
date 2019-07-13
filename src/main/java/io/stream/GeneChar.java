package io.stream;

import java.io.*;

public class GeneChar {
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstCharacter = 33;
        int numberOfCharacter = 94;
        int numberOfCharacterPerLine = 72;

        int start = firstCharacter;
        int circle = 0;
        while (circle < 5) {
            for (int i = start; i < start + numberOfCharacterPerLine; i++) {
                out.write((i - firstCharacter) % numberOfCharacter + firstCharacter);
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstCharacter) % numberOfCharacter + firstCharacter;
            circle ++;
        }
    }

    public static void generateCharactersBuffer(OutputStream out) throws IOException {
        int firstCharacter = 33;
        int numberOfCharacter = 94;
        int numberOfCharacterPerLine = 72;
        int start = firstCharacter;

        byte[] line = new byte[numberOfCharacterPerLine + 2];

        int circle = 0;
        while (circle < 5) {
            for (int i = start; i < start + numberOfCharacterPerLine; i++) {
                line[i - start] = (byte)((i-firstCharacter) % numberOfCharacter + firstCharacter);
            }

            line[72] = (byte) '\r';
            line[73] = (byte) '\n';
            out.write(line);

            start = ((start + 1) - firstCharacter) % numberOfCharacter + firstCharacter;
            circle ++;
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("tmp/text1" );
        FileOutputStream out = new FileOutputStream(file);
        GeneChar.generateCharactersBuffer(out);
        out.close();
    }


}

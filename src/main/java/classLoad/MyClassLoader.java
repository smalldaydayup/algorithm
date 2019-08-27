package classLoad;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class MyClassLoader extends ClassLoader {
    private String swapPath;
    private Set<String> useMyClassLoad;

    public MyClassLoader(String swapPath, Set<String> useMyClassLoad) {
        this.swapPath = swapPath;
        this.useMyClassLoad = useMyClassLoad;
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        if (c == null && useMyClassLoad.contains(name)) {
            c = findClass(name);
            if (c != null) {
                return c;
            }
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = getClassByte(name);
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] getClassByte(String name) {
        String className = name.substring(name.lastIndexOf('.') + 1, name.length()) + ".class";
        try {
            FileInputStream fileInputStream = new FileInputStream(swapPath + className);
            byte[] buffer = new byte[1024];
            int length = 0;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((length = fileInputStream.read(buffer)) > 0) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[]{};
    }
}

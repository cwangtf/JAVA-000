package jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wonderful
 * @date 2020/10/17
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> hello = new HelloClassLoader().findClass("Hello");
            Method method = hello.getMethod("hello");
            method.invoke(hello.newInstance());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File file = new File(this.getClass().getResource("Hello.xlass").getPath());
            FileInputStream in = new FileInputStream(file);
            int length = in.available();
            byte[] bytes = new byte[length];
            in.read(bytes);
            in.close();
            for (int i = 0; i < length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        }
    }

}

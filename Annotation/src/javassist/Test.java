package javassist;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static  void test1() throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool=ClassPool.getDefault();
        CtClass  cc=pool.get("javassist.Emp");
        byte[] bytes=cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
    }

    public static void main(String[] args) throws IOException, CannotCompileException, NotFoundException {
        test1();
    }
}

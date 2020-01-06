package javassist;
import  javassist.ClassPool;
import  javassist.CtClass;


import java.io.IOException;

/**
 * 测试使用javassist
 */
public class Demo1 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.makeClass("javassist.Emp");
        CtField c1 =CtField.make("private int empno;",cc);
        CtField c2 =CtField.make("private int empname;",cc);
        cc.addField(c1);
        cc.addField(c2);
        CtMethod m1=CtMethod.make("public int getEmpno(){return empno}",cc);
        CtMethod m2=CtMethod.make("public int setEmpno(int empno){ this.empno=empno}",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);
        CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        constructor.setBody("{this.empno=empno;this.ename=ename;}");
        cc.addConstructor(constructor);
        cc.writeFile("F:/mytest");
        System.out.println("成功");

    }
}

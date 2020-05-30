package org.nh.gome.demo.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * @program: CreatePerson.java
 * @description:
 * @author: yindanqing
 * @create: 2020/4/28 11:03
 */
public class CreatePerson {

    public static void createPerson() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //创建一个类
        CtClass personClazz = pool.makeClass("org.nh.gome.demo.javassist.Person");

        //创建成员变量
        CtField ageField = new CtField(pool.get("java.lang.Integer"), "age", personClazz);
        ageField.setModifiers(Modifier.PRIVATE);
        personClazz.addField(ageField, CtField.Initializer.constant(0));

        //创建get/set
        personClazz.addMethod(CtNewMethod.setter("setAge", ageField));
        personClazz.addMethod(CtNewMethod.getter("getAge", ageField));

        //创建无参构造
        CtConstructor personConstructor = new CtConstructor(new CtClass[]{}, personClazz);
        personConstructor.setBody("{System.out.println(\"person no args constructor\");}");
        personClazz.addConstructor(personConstructor);

        //创建带参构造
        personConstructor = new CtConstructor(new CtClass[]{pool.get("java.lang.Integer")}, personClazz);
        personConstructor.setBody("{$0.age = $1; System.out.println(\"person all args constructor\");}");
        personClazz.addConstructor(personConstructor);

        //创建方法
        CtMethod logAgeMethod = new CtMethod(CtClass.voidType, "logAgeMethod", new CtClass[]{}, personClazz);
        logAgeMethod.setModifiers(Modifier.PUBLIC);
        logAgeMethod.setBody("{System.out.println(age);}");
        personClazz.addMethod(logAgeMethod);

        //写入文件
        personClazz.writeFile("D:/tmp/0428");

    }


    public static void createPerson2() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //创建一个类
        CtClass personClazz = pool.makeClass("org.nh.gome.demo.javassist.Person");

        //创建成员变量
        CtField ageField = new CtField(pool.get("java.lang.Integer"), "age", personClazz);
        ageField.setModifiers(Modifier.PRIVATE);
        personClazz.addField(ageField);

        //创建get/set
        personClazz.addMethod(CtNewMethod.setter("setAge", ageField));
        personClazz.addMethod(CtNewMethod.getter("getAge", ageField));

        //创建无参构造
        CtConstructor personNoArgsConstructor = CtNewConstructor.make("public Person(){System.out.println(\"person no args constructor\");}", personClazz);
        personClazz.addConstructor(personNoArgsConstructor);

        //创建带参构造
        CtConstructor personAllArgsConstructor =
                CtNewConstructor.make("public Person(int age){this.age = age; System.out.println(\"person no args constructor\");}", personClazz);
        personClazz.addConstructor(personAllArgsConstructor);

        //创建方法
        CtMethod logAgeMethod = new CtMethod(CtClass.voidType, "logAgeMethod", new CtClass[]{}, personClazz);
        logAgeMethod.setModifiers(Modifier.PUBLIC);
        logAgeMethod.setBody("{System.out.println(age);}");
        personClazz.addMethod(logAgeMethod);

        //写入文件
        personClazz.writeFile();

    }


    /**
     * 创建一个Person 对象
     *
     * @throws Exception
     */
    public static void createPersonOriginal() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 1. 创建一个空类
        CtClass personClazz = pool.makeClass("org.nh.gome.demo.javassist.Person");

        // 2. 新增一个字段 private String name;
        // 字段名为name
        CtField param = new CtField(pool.get("java.lang.String"), "name", personClazz);
        // 访问级别是 private
        param.setModifiers(Modifier.PRIVATE);
        // 初始值是 "xiaoming"
        personClazz.addField(param, CtField.Initializer.constant("xiaoming"));

        // 3. 生成 getter、setter 方法
        personClazz.addMethod(CtNewMethod.setter("setName", param));
        personClazz.addMethod(CtNewMethod.getter("getName", param));

        // 4. 添加无参的构造函数
        CtConstructor cons = new CtConstructor(new CtClass[]{}, personClazz);
        cons.setBody("{name = \"xiaohong\";}");
        personClazz.addConstructor(cons);

        // 5. 添加有参的构造函数
        cons = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, personClazz);
        // $0=this / $1,$2,$3... 代表方法参数
        cons.setBody("{$0.name = $1;}");
        personClazz.addConstructor(cons);

        // 6. 创建一个名为printName方法，无参数，无返回值，输出name值
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, personClazz);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(name);}");
        personClazz.addMethod(ctMethod);

        //这里会将这个创建的类对象编译为.class文件
        personClazz.writeFile("D:/tmp/0428");
    }



    public static void main(String[] args) {
        try {
            createPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

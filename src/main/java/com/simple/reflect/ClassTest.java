package com.simple.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-31 11:16
 **/
public class ClassTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?>[] one = {String.class};
        Class<?>[] two = {String.class, int.class};

        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();

        // 1.  获取类的所有构造方法
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("构造器：" + declaredConstructor);
        }

        System.out.println("===========================");
        // 2. 获取public构造器
        Constructor<? extends Student> constructor = aClass.getConstructor();
        System.out.println("构造器名称：" + constructor.getName());
        for (Parameter parameter : constructor.getParameters()) {
            System.out.println("参数名称：" + parameter.getName());
        }

        System.out.println("===========================");

        // 3. 获取指定参数的构造器
        Constructor<? extends Student> customTwoParamCon = aClass.getConstructor(two);
        System.out.println("构造器名称:" + customTwoParamCon);

        // 使用构造器
        customTwoParamCon.newInstance("wcx", 18);

        Constructor<? extends Student> customOneParamCon = aClass.getDeclaredConstructor(one);
        // 不设置这个的话，会抛出异常 Class com.simple.reflect.ClassTest can not access a member of class com.simple.reflect.Student with modifiers "private"
        customOneParamCon.setAccessible(true);
        // 使用构造器
        customOneParamCon.newInstance("wcx");

        System.out.println("===========================");

        // 4. 获取方法
        Method method = aClass.getMethod("noParamVoidPublic");
        Student s = aClass.newInstance();
        System.out.println("方法：" + method.getName());
        // 这里需要传入实例
        method.invoke(s);

        System.out.println("===========================");

        Method noParamVoidPrivate = aClass.getDeclaredMethod("noParamVoidPrivate");
        noParamVoidPrivate.setAccessible(true);
        noParamVoidPrivate.invoke(s);

        System.out.println("===========================");
        Method intVoidPublic = aClass.getMethod("intVoidPublic", int.class);
        // 前面是实例后面是参数
        intVoidPublic.invoke(s, 18);

        System.out.println("===========================");
        Object object = ReflectUtils.createObject(aClass);
        System.out.println(object);
    }
}

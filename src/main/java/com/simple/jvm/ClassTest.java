package com.simple.jvm;

import com.simple.util.BaseTest;
import io.swagger.models.auth.In;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author WuChengXing
 * @date 2021/9/7
 */
public class ClassTest extends BaseTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Integer i = 10;
        Integer j = 10;
        h(i);
        System.out.println(i);
        System.out.println(j);
    }

    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        Integer i = 128;
        Integer j = 128;
        h(i);
        System.out.println(i);
        System.out.println(j);
    }

    public void h(Integer integer) throws NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = integer.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(integer, integer + 1);
    }

}

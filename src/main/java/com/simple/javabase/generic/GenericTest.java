package com.simple.javabase.generic;

import com.simple.javabase.generic.impl.GenericImpl;
import com.simple.javabase.generic.impl.GenericStringImpl;
import com.simple.util.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/7/20
 */
@Slf4j
public class GenericTest extends BaseTest {

    @Test
    public void test01() {
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");

        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        /**
         * 输出结果：泛型逻辑类型不一致，但是对应的=类类型=是否一致：===> true
         *  - Java中的泛型，只在编译阶段有效。
         *  - 在编译过程中，正确检验泛型结果后，会将泛型的相关信息去除
         *  - 运行状态下是不会存在泛型的，都是具体的类型；而且最后比较的话都会是同一个类型的类类型；
         */
        if (classStringArrayList.equals(classIntegerArrayList)) {
            log.info("泛型逻辑类型不一致，但是对应的=类类型=是否一致：===> {}", classStringArrayList.equals(classIntegerArrayList));
        }
    }

    @Test
    public void test02() {
        ResultBody<String> resultBody = new ResultBody<>(200, "成功", "userName");
        log.info("返回值 ===> {}", resultBody);
        // 不管泛型里面传入的是什么 类类型， 最终返回的类类型都是同一个，都是泛型的载体  类类型 ===> class com.simple.javabase.generic.ResultBody
        log.info("类类型 ===> {}", resultBody.getClass());

        /**
         * 泛型的类型参数只能是类类型，不能是简单类型。
         * instanceof操作中不允许出现泛型。如下面的操作是非法的，编译时会出错。
         */
        /*if (resultBody instanceof ResultBody<String>) {

        }*/
    }

    @Test
    public void test03() {
        /**
         * 这里是由子类提供 实际的类类型
         */
        GenericService<String> integerGenericService = new GenericImpl<>();
        String s = integerGenericService.next("111111");
        log.info("客户端自己传入指定的泛型实例 ===> {}", s);

        /**
         * 这是子类实现提供的真是类类型，所以这里无需指定泛型类类型
         */
        GenericService genericService = new GenericStringImpl();
        Object next = genericService.next("11111111");
        log.info("实现类已经指定的泛型实例 ===> {}", next);

        /**
         * 传入泛型参数，但是这并不是泛型方法
         */
        showGeneric(integerGenericService);
    }

    @Test
    public void test04() {
        ResultBody<String> resultBody = new ResultBody<>(1, "111", "不确定泛型");
        /**
         *
         */
        Object o = showUnGeneric(resultBody);
        log.info("通配符方式的泛型 ===> {}", o);
    }

    @Test
    public void test05() {
        GenericMethod<String, Integer> genericMethod = new GenericMethod<>();
        genericMethod.map.put("age", 18);
        genericMethod.map.put("weight", 180);
        int age = genericMethod.dealValue("age");
        log.info("返回值 ===》 {}", age);
    }


    public void showGeneric(GenericService<String> genericService) {
        String next = genericService.next("测试泛型参数");
        log.info(next);
    }

    public <T> T showUnGeneric(ResultBody<?> resultBody) {
        Object data = resultBody.getData();
        return (T) data;
    }

}

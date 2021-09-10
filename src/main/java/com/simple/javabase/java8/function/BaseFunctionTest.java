package com.simple.javabase.java8.function;

import com.simple.util.BaseTest;
import com.simple.util.FunctionUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * @author WuChengXing
 * @date 2021/9/10
 */
public class BaseFunctionTest<T, U, R> extends BaseTest {

    @Test
    public void predicateTest() {
        Predicate<Integer> bool = x -> x > 5;
        System.out.println(bool.test(5));
    }

    @Test
    public void consumerTest() {
        Consumer<Long> consumer = x -> System.out.println(x);
        consumer.accept(1L);
    }

    @Test
    public void supplierTest() {
        Supplier<Integer> supplier = () -> 1 + 1 >> 1 + 1;
        System.out.println(1 + 1 >> 1 + 1);
        System.out.println(supplier.get());
    }

    @Test
    public void binaryOperatorTest() {
        BinaryOperator<Long> add = (x, y) -> x + y;
        System.out.println(add.apply(3L, 4L));
    }

    @Test
    public void nonNullAndIsNumber() {
        FunctionUtil.whenNonNullDo(x -> System.out.println(x.getClass().getTypeName() + ", values: " + x), 1);
        FunctionUtil.whenNonNullDo(x -> System.out.println(x.getClass().getTypeName() + ", values: " + x), 1L);
        FunctionUtil.whenNonNullDo(x -> System.out.println(x.getClass().getTypeName() + ", values: " + x), new BigDecimal(1));
        FunctionUtil.whenNonNullDo(System.out::println, null);
        FunctionUtil.whenNonNullDo(x -> System.out.println(x.getClass().getTypeName() + ", values: " + x), "1");
        System.out.println((Object) null);
    }

    @Test
    public void biFunctionTest() {
        String intOpe = deal(8, 2, "*");
        System.out.println("intOpe:" + intOpe);
        String bigDecimalOpe = deal(new BigDecimal(8), 2, "*");
        System.out.println("bigDecimalOpe:" + bigDecimalOpe);
        String longOpe = deal(new BigDecimal(8), 2L, "*");
        System.out.println("longOpe:" + longOpe);
        String floatOpe = deal(new BigDecimal(8), 2.0, "*");
        System.out.println("floatOpe:" + floatOpe);
    }

    public <NUM1, NUM2, RES extends Number> String deal(NUM1 var1, NUM2 var2, String var3) {
        BiFunction<NUM1, NUM2, RES> biFunction = (multiNum, baseNum) -> ope(multiNum, baseNum, var3);
        return biFunction.andThen(String::valueOf).apply(var1, var2);
    }

    private <NUM1, NUM2, RES extends Number> RES ope(NUM1 var1, NUM2 var2, String var3) {
        String var4 = var1.toString();
        String var5 = var2.toString();
        switch (var3) {
            case "*":
                return (RES) new BigDecimal(var4).multiply(new BigDecimal(var5));
            case "+":
                return (RES) new BigDecimal(var4).add(new BigDecimal(var5));
            case "-":
                return (RES) new BigDecimal(var4).subtract(new BigDecimal(var5));
            case "/":
                return (RES) new BigDecimal(var4).divide(new BigDecimal(var5));
            case "%":
                return (RES) new BigDecimal(var4).remainder(new BigDecimal(var5));
            default:
                return null;
        }
    }

}

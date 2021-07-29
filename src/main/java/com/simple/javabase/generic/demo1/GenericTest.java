package com.simple.javabase.generic.demo1;

import com.simple.javabase.generic.demo1.entity.Apple;
import com.simple.javabase.generic.demo1.impl.BlockOpe;
import com.simple.javabase.generic.demo1.impl.DealOpe;

/**
 * @author WuChengXing
 * @date 2021/7/27
 *
 * 需求：有个水果，需要经过 处理01（清洗/剥皮） ==> 然后再 处理02（榨汁/切块） ==> 最后就是成品；这里有个前置规定，只有较硬的
 * 水果可以切块，软一点的水果只能榨汁；所以可以引入两个父类，块状和液体类；
 *      方案1：每种水果只继承水果父类，然后有个类型type标记软硬，然后下一步做 处理01 处理02，全部写在一个类中，缺点很明显，不符合开闭原则
 *      方案2：将处理01 和 处理02 抽离出来，可以使用桥接模式，比如 清洗 -> 榨汁 / 剥皮 -> 榨汁等迪卡尔积组合；然后新增两个类，TypeBlock、TypeLiquid
 *    水果类继承其，然后 两个处理里面 可以用工厂方法去做对应水果 如 Apple等处理；这个可能就是需要新增水果的时候又要新增方法；
 *      方案3：桥接 + 泛型 + 工厂，这个看代码；
 *
 *
 */
public class GenericTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setName("apple");
        apple.setShape("yuan");
        apple.setSize("big");
        apple.setResult("======== deal fruit ========");
        FruitDeal deal = new DealOpe();
        Operation<Apple> operation = new BlockOpe<>(deal);
        Apple a = operation.Processing(apple);
        System.out.println("最终获取到的结果：==>\n" + a.getResult());
        // Apple processing = operation.Processing(apple);
        // System.out.println(processing);
    }
}

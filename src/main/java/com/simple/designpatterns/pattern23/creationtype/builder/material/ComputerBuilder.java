package com.simple.designpatterns.pattern23.creationtype.builder.material;

import cn.hutool.core.util.StrUtil;
import com.simple.designpatterns.pattern23.creationtype.builder.constant.BuilderConstant;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-19 00:09
 **/
public class ComputerBuilder {

    public static void builder(String level) {
        if (BuilderConstant.LEVEL_HIGH.equals(level)) {
            highBuilder();
        } else if (BuilderConstant.LEVEL_MID.equals(level)) {
            midBuilder();
        } else if (BuilderConstant.LEVEL_LOW.equals(level)) {
            lowBuilder();
        }
    }

    /**
     * 这些builder可以作为子建造者，以集成的方式做，类似于工厂，之后想增加新的构建的时候，只要新加类就行，不会对代码造成侵入
     *
     * @return
     */
    private static void highBuilder() {
        CPU cpu = Intel.IntelFactory.create(BuilderConstant.LEVEL_HIGH);
        Disk disk = Kingston.KingstonFactory.create(BuilderConstant.LEVEL_HIGH);
        Memory memory = Samsung.SamsungFactory.create(BuilderConstant.LEVEL_HIGH);
        printLevel(cpu, disk, memory, "high");
    }

    private static void midBuilder() {
        CPU cpu = Intel.IntelFactory.create(BuilderConstant.LEVEL_MID);
        Disk disk = Kingston.KingstonFactory.create(BuilderConstant.LEVEL_MID);
        Memory memory = Samsung.SamsungFactory.create(BuilderConstant.LEVEL_MID);
        printLevel(cpu, disk, memory, "mid");
    }

    private static void lowBuilder() {
        CPU cpu = Intel.IntelFactory.create(BuilderConstant.LEVEL_LOW);
        Disk disk = Kingston.KingstonFactory.create(BuilderConstant.LEVEL_LOW);
        Memory memory = Samsung.SamsungFactory.create(BuilderConstant.LEVEL_LOW);
        printLevel(cpu, disk, memory, "low");
    }

    private static void printLevel(CPU cpu, Disk disk, Memory memory, String type) {
        BigDecimal decimal = Objects.requireNonNull(cpu)
                .price.add(Objects.requireNonNull(disk)
                        .price.add(Objects.requireNonNull(memory).price));
        System.out.println("========== " + type.toUpperCase() + " ===========");
        System.out.println("========== CPU:" + cpu.brand + "/" + cpu.brand + "/"
                + cpu.size + "/" + cpu.desc + ", " + "价格：===> " + cpu.price + " ===========");
        System.out.println("========== DISK:" + disk.brand + "/" + disk.brand + "/"
                + disk.size + "/" + disk.desc + ", " + "价格：===> " + disk.price +  " ===========");
        System.out.println("========== MEMORY:" + memory.brand + "/" + memory.brand + "/"
                + memory.size + "/" + memory.desc + ", " + "价格：===> " + memory.price +  " ===========");
        System.out.println(type + "--价格(总价)：===> " + decimal);
    }
}

package com.simple.jvm.classparsing.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/10/20
 */
public class CycleToString {

    @Override
    public String toString() {
        return "CycleToString: " + this + "\n";
    }

    public static void main(String[] args) {
        List<CycleToString> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new CycleToString());
        }
        System.out.println(list);
    }


}

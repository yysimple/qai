package com.simple.designpatterns.pattern23.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 记录着
 *
 * @author: WuChengXing
 * @create: 2021-07-03 10:55
 **/
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

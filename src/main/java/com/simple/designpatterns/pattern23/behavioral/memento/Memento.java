package com.simple.designpatterns.pattern23.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 备忘录
 *
 * @author: WuChengXing
 * @create: 2021-07-03 10:49
 **/
public class Memento {
    private String operation;

    private Integer version;


    public Memento() {
    }

    public Memento(String operation, Integer version) {
        this.operation = operation;
        this.version = version;
    }

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

    public String getOperation() {
        return operation;
    }

    public Integer getVersion() {
        return version;
    }
}

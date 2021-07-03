package com.simple.designpatterns.pattern23.behavioral.memento;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 操作者
 *
 * @author: WuChengXing
 * @create: 2021-07-03 10:50
 **/
public class Originator {
    private String operation;

    private Integer version;

    public Originator(String operation, Integer version) {
        this.operation = operation;
        this.version = version;
    }

    public Originator() {
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getOperation() {
        return operation;
    }

    public Integer getVersion() {
        return version;
    }

    /**
     * 保存版本
     *
     * @return
     */
    public Memento save() {
        return new Memento(operation, version);
    }

    /**
     * 获取每个版本的信息
     *
     * @param memento
     */
    public void getMemento(Memento memento) {
        operation = memento.getOperation();
        version = memento.getVersion();
    }
}

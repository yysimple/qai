package com.simple.designpatterns.pattern23.structuretype.bridging;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 菜系
 *
 * @author: WuChengXing
 * @create: 2021-06-26 10:19
 **/
public abstract class Cuisine {

    protected String name;

    /**
     * 这里已经娃完成初始化了，所以子类只需要调用一下构造器就可以使用 name属性了
     *
     * @param name
     */
    public Cuisine(String name) {
        this.name = "aaa";
    }

    protected CookingMethod cookingMethod;

    public Cuisine(CookingMethod cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    /**
     * 制作完成
     */
    public abstract void finishedProduct();
}

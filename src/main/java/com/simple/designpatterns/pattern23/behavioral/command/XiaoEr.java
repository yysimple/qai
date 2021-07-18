package com.simple.designpatterns.pattern23.behavioral.command;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 调用者
 *
 * @author: WuChengXing
 * @create: 2021-06-28 22:53
 **/
@Slf4j
public class XiaoEr {
    private List<ICuisine> cuisines = new ArrayList<>();

    /**
     * 这里相当于将命令放到sh文件中，用于批量执行
     * @param cuisine
     */
    public void addCuisine(ICuisine cuisine) {
        cuisines.add(cuisine);
    }

    /**
     * 这里可以理解为文件的执行命令，启动脚本等、如 .sh或者.exe
     */
    public synchronized void placeOrder(){
        for (ICuisine cuisine : cuisines) {
            cuisine.getCuisine();
        }
        cuisines.clear();
    }
}

package com.simple.designpatterns.pattern23.structuretype.bridging;

import com.simple.designpatterns.pattern23.structuretype.bridging.impl.Boiled;
import com.simple.designpatterns.pattern23.structuretype.bridging.impl.Pasta;
import com.simple.designpatterns.pattern23.structuretype.bridging.impl.RiceFlour;
import com.simple.designpatterns.pattern23.structuretype.bridging.impl.StirFry;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 桥接模式
 *
 * @author: WuChengXing
 * @create: 2021-06-20 13:07
 **/
public class BridgingTest {
    public static void main(String[] args) {
        Cuisine boiledRiceFlour = new RiceFlour(new Boiled());
        boiledRiceFlour.finishedProduct();
        System.out.println("-----------------------------");
        Cuisine stirFryRiceFlour = new RiceFlour(new StirFry());
        stirFryRiceFlour.finishedProduct();
        System.out.println("-----------------------------");
        Cuisine boiledPasta = new Pasta(new Boiled());
        boiledPasta.finishedProduct();
        System.out.println("-----------------------------");
        Cuisine riceFlourStirFry = new RiceFlour(new StirFry());
        riceFlourStirFry.finishedProduct();


    }
}

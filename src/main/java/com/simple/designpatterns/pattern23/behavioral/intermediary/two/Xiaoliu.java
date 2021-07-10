package com.simple.designpatterns.pattern23.behavioral.intermediary.two;

import com.simple.designpatterns.pattern23.behavioral.intermediary.two.impl.Tenant;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 中介者，既要负责带看房，也要联系房东签合同
 *
 * @author: WuChengXing
 * @create: 2021-07-11 01:12
 **/
public class Xiaoliu extends Landlord implements Renting{
    @Override
    public void signContract() {
        super.signContract();
    }

    @Override
    public void viewHouse(Tenant tenant) {
        System.out.println("小刘：您好，" + tenant.getName() +"先生/女士，我是小刘，看房子的找我就行，我来接你看房子，请稍等");
        System.out.println("小刘：您觉得合适吗？");
        if (tenant.getRenting()) {
            System.out.println(tenant.getName() + ": 可以的，非常符合我现在的要求，签合同吧！");
            this.signContract();
        }else {
            System.out.println(tenant.getName() + ": 我需要在考虑一下，之后给你答复");
            System.out.println("小刘：好的呢，亲，有需要再联系！我们房很好的！");
        }
    }
}

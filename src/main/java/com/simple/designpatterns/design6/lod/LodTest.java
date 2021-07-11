package com.simple.designpatterns.design6.lod;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/10 11:26
 */
public class LodTest {
    public static void main(String[] args) {
        /**
         * 迪米特法则：最少知道原则，其实也就是各司其职，就像事业部总经理只关心整个部门的业绩情况（只需要向每个业务组组长问数据就行），
         * 而具体评分、统计就由每个组组长去做就行了！！
         *
         *     1. 优先考虑将一个类设置成不变类。
         *     2. 尽量降低一个类的访问权限。
         *     3. 谨慎使用Serializable。
         *     4. 尽量降低成员的访问权限。
         */

        /**
         * 总经理.total();
         * total() {
         *    return aGroup.total() + bGroup.total()
         * }
         *
         * AGroup{
         *     total(){
         *         return 1000W;
         *     }
         * }
         *
         * BGroup{
         *     total(){
         *         return 500W;
         *     }
         * }
         */

    }
}

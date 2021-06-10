package com.simple.designpatterns.design6.dip;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/10 18:29
 */
public class DipTest {
    /**
     * 依赖倒置原则：是指在设计代码架构时，高层模块不应该依赖于底层模块，二者都应该依赖于抽象。抽象不应该依赖于细节，细节应该依赖于抽象。
     * 这个意思就是：最好不要两个实现类互相调用，而是使用其接口进行调用
     */

    /**
     * interface AService{
     *
     * }
     *
     * AServiceImpl implements AService{
     *
     * }
     *
     * interface BService{
     *
     * }
     *
     * BServiceImpl implements BService{
     *      // 这里应该注入的是接口，实现可能会存在很多，这样才符合
     *      AService aService;
     * }
     *
     *
     *
     */
}

package java.lang;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 双亲委派测试
 *
 * @author: WuChengXing
 * @create: 2021-03-24 17:29
 **/
public class String {
    public static void main(String[] args) {

        /**
         * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
         *    public static void main(String[] args)
         * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
         *
         *
         * 这里是保证：引导类加载器加载的类不被修改
         */
        System.out.println("双亲委派测试");
    }
}

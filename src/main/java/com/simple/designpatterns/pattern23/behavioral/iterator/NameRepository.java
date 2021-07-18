package com.simple.designpatterns.pattern23.behavioral.iterator;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-28 23:39
 **/
public class NameRepository implements Iterable {

    public String[] names = {"Robert", "John", "Julie", "Lora"};

    /**
     * 获取迭代器
     * @return
     */
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        /**
         * 根据数组长度校验是否还有下一个元素
         * @return
         */
        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                /**
                 * 这里index++ 知道没有下一个元素这里就不执行了
                 */
                return names[index++];
            }
            return null;
        }
    }
}

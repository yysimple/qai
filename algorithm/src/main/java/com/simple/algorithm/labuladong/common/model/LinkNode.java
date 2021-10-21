package com.simple.algorithm.labuladong.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author WuChengXing
 * @date 2021/10/19
 */
@Getter
@Setter
@ToString
public class LinkNode<T> {
    public LinkNode<T> next;
    public T val;

    /**
     * 单向链表
     *
     * @param next
     * @param val
     */
    public LinkNode(LinkNode<T> next, T val) {
        this.next = next;
        this.val = val;
    }

    /*@Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val).append("->");

        StringBuilder to = to(next, this, stringBuilder);
        String[] split = to.toString().split("->");
        List<String> strings = Arrays.asList(split);
        Collections.reverse(strings);
        return StringUtils.join(strings, "->");
    }

    StringBuilder to(LinkNode<T> next, LinkNode<T> nexth, StringBuilder sb) {
        if (next.equals(nexth)) {
            sb.append(next.val);
            return sb;
        }
        sb.append(next.val).append("->");
        to(next.next, nexth, sb);
        return sb;
    }*/
}

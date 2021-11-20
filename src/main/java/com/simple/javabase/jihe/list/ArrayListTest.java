package com.simple.javabase.jihe.list;

import org.junit.Test;

import java.util.*;

/**
 * @author WuChengXing
 * @date 2021/11/18
 */
public class ArrayListTest extends ArrayList {

    @Test
    public void normalTest() {
        int old = 10;
        System.out.println(old >> 1);
    }

    @Test
    public void trimToSizeTest() {
        ArrayList al = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        al.add(1);
        al.trimToSize();
        System.out.println("减少数组容量之后: " + al.size());
    }

    @Test
    public void testIndexOf() {
        ArrayList<Integer> arrayList = new ArrayList<>(8);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(null);
        arrayList.add(3);
        long start = System.currentTimeMillis();
        int i = arrayList.indexOf(null);
        System.out.println(i);
        long end = System.currentTimeMillis();
        System.out.println("初始化容量构造器：" + (end - start));
    }

    @Test
    public void cloneTest() {
        ArrayList<Integer> arrayList = new ArrayList<>(8);
        arrayList.add(1);
        // [1]
        System.out.println(arrayList);

        Object clone = arrayList.clone();
        arrayList.clear();
        // [1]
        System.out.println(clone);
        // []
        System.out.println(arrayList);
    }

    @Test
    public void toArrayTest() {
        ArrayList<Integer> arrayList = new ArrayList<>(8);
        arrayList.add(1);
        Object[] objects = arrayList.toArray();
        System.out.println(objects.length);
    }

    @Test
    public void toArgArrayTest() {
        ArrayList<String> arrayList = new ArrayList<>(8);
        arrayList.add("1");
        String[] strings = arrayList.toArray(new String[arrayList.size()]);
        System.out.println(strings.length);
    }

    @Test
    public void removeRangeTest() {
        ArrayList<String> arrayList = new ArrayList<>(8);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        removeRange(1, 3);
        System.out.println(arrayList);
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

    @Test
    public void removeAllTest() {
        ArrayList<String> arrayList1 = new ArrayList<>(8);
        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        arrayList1.add("4");
        arrayList1.add("5");
        arrayList1.add("6");
        ArrayList<String> arrayList2 = new ArrayList<>(8);
        arrayList2.add("4");
        arrayList2.add("2");
        arrayList2.add("3");
        boolean b = arrayList1.removeAll(arrayList2);
        System.out.println(b);
        System.out.println(arrayList1);
    }

    @Test
    public void retainAllTest() {
        ArrayList<String> arrayList1 = new ArrayList<>(8);
        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        arrayList1.add("4");
        arrayList1.add("5");
        arrayList1.add("6");
        ArrayList<String> arrayList2 = new ArrayList<>(8);
        arrayList2.add("4");
        arrayList2.add("2");
        arrayList2.add("3");
        arrayList2.add("7");
        boolean b = arrayList1.retainAll(arrayList2);
        System.out.println(b);
        System.out.println(arrayList1);
    }

    @Test
    public void listIteratorHasArgTest() {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        arrayList1.add("4");
        arrayList1.add("5");
        arrayList1.add("6");
        ListIterator<String> stringListIterator = arrayList1.listIterator(arrayList1.size());
        for (ListIterator<String> s = stringListIterator; s.hasPrevious(); ) {
            System.out.println(s.previous());
        }
    }

    @Test
    public void listIteratorNoArgTest() {
        ArrayList<String> arrayList1 = new ArrayList<>(8);
        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        arrayList1.add("4");
        arrayList1.add("5");
        arrayList1.add("6");
        for (ListIterator<String> s = arrayList1.listIterator(); s.hasNext(); ) {
            System.out.println(s.next());
        }
    }

    @Test
    public void listIteratorCurrTest() {
        ArrayList<String> arrayList = new ArrayList<>(8);
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i + "");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrayList.size());
        new Thread(() -> {
            for (ListIterator<String> s = arrayList.listIterator(); s.hasNext(); ) {
                System.out.println(s.next());
            }
        }).start();

        new Thread(() -> {
            for (ListIterator<String> s = arrayList.listIterator(); s.hasNext(); ) {
                System.out.println(s.next());
            }
        }).start();
    }

    @Test
    public void removeCurrTest() {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("333");
        Iterator iterator = list.iterator();
        //foreach循环删除 java.util.ConcurrentModificationException
        while (iterator.hasNext()) {
            if (iterator.next().equals("222")) {
                // 使用的是ArrayList的删除方法，是外部
                list.remove(iterator.next());
            }
        }
        // 这个是可以正常删除的
        while (iterator.hasNext()) {
            if (iterator.next().equals("222")) {
                // 使用的时候迭代器内部，Itr类里面的remove的
                iterator.remove();
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void forEachRemainingTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> newList = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
        iterator.forEachRemaining(i -> newList.add(i * 2));
        System.out.println(newList);
    }

    @Test
    public void subListTest() {
        List<String> names = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};

        List subList = names.subList(0, 1);
        System.out.println(subList);
    }
}

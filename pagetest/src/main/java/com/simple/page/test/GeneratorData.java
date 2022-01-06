package com.simple.page.test;

import com.simple.page.domain.SingleTable;
import com.simple.page.mapper.SingleTableMapper;
import com.simple.page.service.SingleTableService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-06 17:45
 **/
@SpringBootTest
public class GeneratorData {

    @Resource
    private SingleTableService service;

    @Test
    public void test() {
        List<SingleTable> singleTables = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            SingleTable singleTable = new SingleTable();
            singleTable.setId(i + 1);
            singleTable.setKey1(getRandomCode(4, i % 7));
            singleTable.setKey2(i);
            singleTable.setKey3(getRandomCode(3, i % 7));
            singleTable.setKeyPart1(getRandomCode(4, (i+1) % 7));
            singleTable.setKeyPart2(getRandomCode(5, (i+2) % 7));
            singleTable.setKeyPart3(getRandomCode(4, (i+3) % 7));
            singleTable.setCommonField((10000 % 99) + "");
            singleTables.add(singleTable);
        }
        service.saveBatch(singleTables);
    }

    public static void main(String[] args) {

    }

    /**
     * @param passLength : 要生成多少长度的字符串
     * @param type       : 需要哪种类型
     * @return 根据传入的type来判定
     */

    // 可以根据自己需求来删减下面的代码，不要要的类型可以删掉

    // type=0：纯数字(0-9)
    // type=1：全小写字母(a-z)
    // type=2：全大写字母(A-Z)
    // type=3: 数字+小写字母
    // type=4: 数字+大写字母
    // type=5：大写字母+小写字母
    // type=6：数字+大写字母+小写字母
    // type=7：固定长度33位：根据UUID拿到的随机字符串，去掉了四个"-"(相当于长度33位的小写字母加数字)
    public static String getRandomCode(int passLength, int type) {
        StringBuffer buffer = null;
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        r.setSeed(new Date().getTime());
        switch (type) {
            case 0:
                buffer = new StringBuffer("0123456789");
                break;
            case 1:
                buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
                break;
            case 2:
                buffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 3:
                buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyz");
                break;
            case 4:
                buffer = new StringBuffer("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 5:
                buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 6:
                buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
                sb.append(buffer.charAt(r.nextInt(buffer.length() - 10)));
                passLength -= 1;
                break;
            case 7:
                String s = UUID.randomUUID().toString();
                sb.append(s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24));
        }

        if (type != 7) {
            int range = buffer.length();
            for (int i = 0; i < passLength; ++i) {
                sb.append(buffer.charAt(r.nextInt(range)));
            }
        }
        return sb.toString();
    }
}

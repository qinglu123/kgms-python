package com.lq.abstractt;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.abstractt
 * @Author: LuQing
 * @CreateTime: 2023-03-03  14:17
 * @Description: TODO
 * @Version: 1.0
 */
public abstract class AbstractDemo {
    public void a() {
        System.out.println("a");
    }

    public abstract void b();

    public static void main(String[] args) {
//        AbstractDemo ad = new AbstractDemo() {
//            @Override
//            public void b() {
//                System.out.println("b");
//            }
//        };
//        ad.b();

        System.out.println(totalFormat(2023432L));

    }

    public static String totalFormat(Long total) {
        if (total >= 10000) {
            BigDecimal bigDecimal = new BigDecimal(total);
            //转换位万
            BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
            //保留两位小数
            DecimalFormat format = new DecimalFormat("0.00");
            return format.format(decimal);
        }
        return total + "";
    }
}

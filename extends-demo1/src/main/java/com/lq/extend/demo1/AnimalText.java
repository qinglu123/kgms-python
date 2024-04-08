package com.lq.extend.demo1;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.extend.demo1
 * @Author: LuQing
 * @CreateTime: 2023-02-03  14:26
 * @Description: TODO
 * @Version: 1.0
 */
public class AnimalText {
    public static void main(String[] args) {
//        Rabbit rabbit = new Rabbit();
//        rabbit.eat();
//        rabbit.sleep();
//        System.out.println("==================");
//        Tiger tiger = new Tiger();
//        tiger.eat();
//        tiger.sleep();

//        Class<Tiger> c1 = Tiger.class;
//        Class<? extends Tiger> c2 = new Tiger().getClass();
//        System.out.println(c1 == c2);

//        Double i1 = Double.valueOf(1);
//        Double i2 = Double.valueOf(1);
//        System.out.println(i1==i2);

//        int i = m();
//        System.out.println(i);
//        int s = f(2);
//        System.out.println(s);

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
//            if (value == 2) {
            return 0;
//            }
        }
    }

    public static int m() {
        int i = 100;
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i++;
        }
        return i;
    }
}

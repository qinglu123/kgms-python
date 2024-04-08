package com.lq.abstractd;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.abstractd
 * @Author: LuQing
 * @CreateTime: 2023-02-18  12:01
 * @Description: TODO
 * @Version: 1.0
 */
public abstract class demo1 {
    public abstract void a();

    public static void main(String[] args) {
        demo1 demo1 = new demo1() {
            @Override
            public void a() {
                System.out.println("aaa");
            }
        };
        demo1.a();
    }
}

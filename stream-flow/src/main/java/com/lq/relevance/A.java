package com.lq.relevance;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.relevance
 * @Author: LuQing
 * @CreateTime: 2023-02-28  11:53
 * @Description: TODO
 * @Version: 1.0
 */
public class A {
    public void method1(){
        B b = new B();
        b.method1();
    }
    public void method2(){
        B.method2();
    }

    public void method3(B b){
        String s = b.field1;
    }

    public B method4(){
        return new B();
    }
}

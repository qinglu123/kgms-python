package com.lq.druidd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.druidd
 * @Author: LuQing
 * @CreateTime: 2023-02-27  19:29
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0; i--){
            list.add(i);
        }
        Stream<Integer> sorted = list.stream().sorted();
        sorted.forEach(a-> System.out.print(a));
        System.out.println("====================");
        list.stream().forEach(b -> System.out.print(b));
    }
}

package com.lq.stream;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.stream
 * @Author: LuQing
 * @CreateTime: 2023-02-03  15:13
 * @Description: TODO
 * @Version: 1.0
 */

/**
 * JDK 1.8 新特性 stream流
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {

        //单列集合
//        List<Customer> list = new ArrayList();
//        Stream<Customer> stream = list.stream();
//        list.add(new Customer("A",1));
//        list.add(new Customer("B",2));
//        list.add(new Customer("C",3));
//        list.add(new Customer("D",4));
//        stream.forEach(customer -> System.out.println(customer.getName()+":"+customer.getId()));

        //双列集合
//        Map<Integer,String> map = new HashMap<>();
//
//        map.put(1,"A");
//        map.put(2,"B");
//        map.put(3,"C");
//        map.put(4,"D");
//
//        Stream<Integer> stream = map.keySet().stream(); //获取map中的key
//        Stream<Map.Entry<Integer, String>> stream1 = map.entrySet().stream(); //获取map中的键值对
//        Stream<String> stream2 = map.values().stream(); //获取map中的value
//
//        stream.forEach(s -> System.out.println(s));
//        stream1.forEach(s1 -> System.out.println(s1));
//        stream1.forEach(ss -> System.out.println(ss.getKey() +" " + ss.getValue()));
//        stream2.forEach(s2 -> System.out.println(s2));

        //array
//        String[] str = new String[3];
//        for (int i = 0; i < str.length; i++) {
//            str[i] = (i+1)+"";
//        }
//        Integer[] num = {1,2,3};
//        Stream<String> stream = Arrays.stream(str);
//        stream.forEach(s -> System.out.println(s));
//        Stream<Integer> stream1 = Arrays.stream(num);
//        stream1.forEach(n -> System.out.println(n));

        //同种类型多个数据
//        Stream<String> stream2 = Stream.of("A", "B", "C");
//        stream2.forEach(s -> System.out.println(s));

        //获取并行流
//        List<String> strings = Arrays.asList("LuQing", "AAA", "BBB");
//        Stream<String> stringStream = strings.parallelStream();
//        stringStream.forEach(s -> System.out.println(s));

        //文件流
//        Stream<String> lines = Files.lines(get("C:\\Users\\芦庆\\Desktop\\readme.txt"), Charset.defaultCharset());
//        lines.forEach(line -> System.out.println(line));


        //通过函数
//        Stream<Integer> iterate = Stream.iterate(-99, i -> i + 1);
//        iterate.limit(100).forEach(x -> System.out.println(x));

//        Stream<Double> generate = Stream.generate(Math::random);
//        generate.limit(10).forEach(num -> System.out.println(num));
    }
}

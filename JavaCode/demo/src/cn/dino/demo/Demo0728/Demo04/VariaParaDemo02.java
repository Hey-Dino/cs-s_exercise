package cn.dino.demo.Demo0728.Demo04;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class VariaParaDemo02 {
    public static void main(String[] args) {
        Integer[] nums = {12, 22, 32, 42, 52};

        /*
        若需要以数组作为asList的参数，则该数组的数据类型不能是基本类型，必须是其包装类；
        否则，整个数组会被当成一个对象。
        */
        List<Integer> list1 = Arrays.asList(12, 22, 32, 42);
        List<Integer> list2 = Arrays.asList(nums);
        for (int v:list2) {
            System.out.print(v + " ");
        }
        System.out.println();
        /*
        * asList() 生成的集合只能修改，不能增加、移除
        * 执行增加、移除操作会报错：UnsupportedOperationException
        * */
        // list2.add(0);
        // list2.remove(0);
        list2.set(0, 2);

        /*
        * List.of() 产生的集合，长度、内容不可变，即不可做增、删、改操作
        * List.of() 是JDK1.9后新增的方法
        * */
        List<Integer> list3 = List.of(nums);

        /*
        * Set.of() 产生的集合，长度、内容不可变，即不可做增、删、改操作
        * 同时，内容唯一不重复
        *
        * Set.of() 是JDK1.9后新增的方法
        * */
        Set.of(nums);
    }
}

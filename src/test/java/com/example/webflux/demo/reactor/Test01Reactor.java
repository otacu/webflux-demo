package com.example.webflux.demo.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 姿势帝-博客园
 * @address https://www.cnblogs.com/newAndHui/
 * @WeChat 851298348
 * @create 01/15 7:40
 * @description * <p>
 * 单词认识
 * 1.mono
 * 英 [ˈmɒnəʊ]   美 [ˈmɑːnoʊ]
 * adj.单声道的   n.单声道录音(或放音)系统
 * 2.flux
 * 英 [flʌks]   美 [flʌks]
 * n.不断的变动;不停的变化;通量;流动  v.熔化;熔解;流出
 * </P>
 * Publisher 发送（生产者，可以类比为把数据放入redis）
 * subscribe 订阅（消费者，可以类比为从redis中读取数据）
 * <p>
 * 1.响应式编程操作中，Reactor 是满足 Reactive 规范框架
 * 2.Reactor 有两个核心类，Mono 和 Flux，这两个类实现接口 Publisher，提供丰富操作API;
 * 2.1.Flux 对象实现发布者，返回 N 个元素；
 * 2.2.Mono 实现发布者，返回 0 或者 1 个元素
 * <p>
 * 3.Flux 和 Mono 都是数据流的发布者，使用 Flux 和 Mono 都可以发出三种数据信号：
 * 元素值
 * 错误信号
 * 完成信号
 * 错误信号和完成信号:都代表终止信号，终止信号用于告诉订阅者数据流结束了;
 * 错误信号终止数据流同时把错误信息传递给订阅者;
 */
public class Test01Reactor {
    /**
     * 简单使用
     */
    @Test
    public void test01() {
        // just方法直接声明
        // 2.1.Flux 对象实现发布者，返回 N 个元素 (实际开发中我们可以放入产品列表数据)
        Flux.just("张三", "李四", "王五", "赵六").subscribe(System.out::println);
        System.out.println("====================================================");
        // 2.2.Mono 实现发布者，返回 0 或者 1 个元素 （实际开发中我们可以放入根据id查询的单条数据）
        Mono.just("张无忌").subscribe(System.out::println);
    }

    /**
     * Flux 的formXXX声明
     */
    @Test
    public void test02() {
        System.out.println("数组.....");
        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array).subscribe(System.out::println);

        System.out.println("集合.....");
        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list).subscribe(System.out::println);

        System.out.println("流.....");
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream).subscribe(System.out::println);
    }
}

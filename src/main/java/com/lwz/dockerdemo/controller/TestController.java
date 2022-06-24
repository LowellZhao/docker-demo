package com.lwz.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwz
 * @since 2022/6/24
 */
@RestController
public class TestController {

    /**
     * cpu 占满
     *
     * @return
     */
    @GetMapping("/cpu/loop")
    public String testCpuLoop() {
        System.out.println("模拟请求，死循环导致cpu占满");
        int num = 1;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }
    }

    /**
     * 内存溢出
     *
     * @return
     */
    @GetMapping("/memory/leak")
    public String lear() {
        System.out.println("模拟内存泄漏");
        ThreadLocal<Byte[]> localVariable = new ThreadLocal<>();
        // 为线程添加变量
        localVariable.set(new Byte[10 * 4096 * 1024]);
        return "ok";
    }

    /**
     * 内存溢出 加载的对象太⼤
     *
     * @return
     */
    @GetMapping("/memory/leak1")
    public String test() {
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Byte[100 * 1024 * 1024]);
        }
        return "succ";
    }
}

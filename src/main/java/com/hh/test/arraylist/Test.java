package com.hh.test.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试ArrayList
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/1/25
 */
public class Test {
    public static void main(String[] args) {
        new Test().testExpandCapacity();
    }

    /**
     * 测试扩容
     */
    private void testExpandCapacity() {
        // 给定一个默认大小，查看是否扩容
        List<String> list = new ArrayList<>(1);
        list.add("test");
    }
}

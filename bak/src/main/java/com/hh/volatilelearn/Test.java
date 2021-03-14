package com.hh.volatilelearn;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/2/22
 */
public class Test {
    public static void main(String[] args) {
        Param param = new Param();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                param.writer();
            }
        });
        for (int i = 0; i < 10; i++) {
            Thread threadB = new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = 0;
                    do {
//                        a = param.read();
                    } while (a != 4);
                }
            });
            threadB.start();
        }

        threadA.start();
    }
}
class Param {
    private int i = 0;
    private volatile boolean flag = false;

    public void writer() {
        i = 2;
        flag = true;
    }

    public void read() {
        int a = 1;
        if (flag) {
             a = i * i;
        }
    }
}


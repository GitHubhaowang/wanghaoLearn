package com.hh.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskDemo {

    private class SumTask extends RecursiveTask<Long> {

        private static final int THRESHOLD = 100000000;

        private int arr[];
        private int start;
        private int end;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        /**
         * 小计
         */
        private Long subtotal() {
            Long sum = 0L;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
//            System.out.println(Thread.currentThread().getName() + ": ∑(" + start + "~" + end + ")=" + sum);
            return sum;
        }

        @Override
        protected Long compute() {

            if ((end - start) <= THRESHOLD) {
                return subtotal();
            }else {
                int middle = (start + end) / 2;
                SumTask left = new SumTask(arr, start, middle);
                SumTask right = new SumTask(arr, middle, end);
                left.fork();
                right.fork();

                return left.join() + right.compute();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = new int[1000000000];
        for (int i = 0; i < 1000000000; i++) {
            arr[i] = i + 1;
        }
        long begtime = System.currentTimeMillis();
//        forkjoin(arr);
        add(arr);
        long endtime = System.currentTimeMillis();
        System.out.println("消耗时间：" + (endtime - begtime));
    }

    public static void forkjoin(int[] arr) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> result = pool.submit(new ForkJoinTaskDemo().new SumTask(arr, 0, arr.length));
        System.out.println("最终计算结果: " + result.invoke());
        pool.shutdown();
    }

    public static void add(int[] arr) {
        long num = 0L;
        for (int i : arr) {
            num += i;
        }
        System.out.println("最终计算结果: " + num);
    }

}
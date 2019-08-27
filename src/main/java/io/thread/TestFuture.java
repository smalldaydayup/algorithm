package io.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return new Random().nextInt(100);
//            }
//        });
//
//        new Thread(task).start();
//        System.out.println(task.get());

        FutureTask<Integer> task1 = new FutureTask<>(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task");
            }
        }, 85);

        new Thread(task1).start();
        System.out.println(task1.get());
    }






}


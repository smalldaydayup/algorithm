package io.thread;

public class TestThread {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(2000 * ( 4 - i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("nihao" + i);
            }

        }).start();
    }
}

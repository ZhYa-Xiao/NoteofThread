package com.hspedu.exit_;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        AThread aThread = new AThread();
        Thread thread = new Thread(aThread);
        for (int i = 1; i < 11; i++) {
            if(i == 6) {
                thread.start();
                thread.join();
            }
            System.out.println("hi" + i);
            Thread.sleep(1000);
        }
    }
}

class AThread implements Runnable {

    @Override
    public void run() {
        int count = 1;
        while (true) {
            if(count > 10) {
                System.out.println("子线程退出");
                break;
            }
            System.out.println("hello" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}
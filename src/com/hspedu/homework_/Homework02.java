package com.hspedu.homework_;

public class Homework02 {
    public static void main(String[] args) {
        Chao chao = new Chao();
        Thread thread = new Thread(chao);
        Thread thread1 = new Thread(chao);
        thread.start();
        thread1.start();
    }
}

class Chao implements Runnable {
    static int change = 100000;
    Object object = new Object();
    public void m() {
        synchronized (object) {
            if(change == 0){
                return;
            }
            change -= 1000;
            System.out.println(Thread.currentThread().getName() + "取款1000,余额为" + change);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            m();
        }

    }
}
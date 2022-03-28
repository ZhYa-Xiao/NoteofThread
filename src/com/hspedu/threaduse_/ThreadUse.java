package com.hspedu.threaduse_;

public class ThreadUse {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.start();

        for (int i = 0; i < 600; i++) {
            System.out.println("主线程= " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cat extends Thread {
    @Override
    public void run() {
        int time = 1;
        while (true) {
            if(time == 800) {
                break;
            }
            System.out.println("喵喵" + time + "线程名" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
        }
    }
}
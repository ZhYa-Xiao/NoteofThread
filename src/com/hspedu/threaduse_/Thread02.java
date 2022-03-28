package com.hspedu.threaduse_;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
        Tiger tiger = new Tiger();
        Thread thread1 = new Thread(tiger);
        thread1.start();

    }
}


//静态代理模式模拟！！！！！！！！！！！！！！！！！！！！！！
//静态代理模式模拟！！！！！！！！！！！！！！！！！！！！！！
//静态代理模式模拟！！！！！！！！！！！！！！！！！！！！！！
//静态代理模式模拟！！！！！！！！！！！！！！！！！！！！！！
//静态代理模式模拟！！！！！！！！！！！！！！！！！！！！！！
class Animal{}
class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("老虎汪汪叫");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadProxy implements Runnable {

    private Runnable target = null;
    @Override
    public void run() {
        target.run();
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();
    }

    public void start0() {
        run();
    }
}

class Dog implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫" + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
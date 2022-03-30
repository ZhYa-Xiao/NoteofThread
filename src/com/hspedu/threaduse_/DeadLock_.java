package com.hspedu.threaduse_;

public class DeadLock_ {
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock(true);
        Deadlock deadlock1 = new Deadlock(false);

        deadlock.start();
        deadlock1.start();
    }
}

class Deadlock extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public Deadlock(boolean flag) {
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag) {//可以理解为两个人分别要进不同的厕所，但都同时需要两把锁才能进，
            //但双方都只能把锁牢牢抓在自己手上，因为锁只有在进过厕所后才能被释放，于是两人都进不了厕所
            synchronized (o1) {//必须要拿到o1才能拿到o2
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        } else {
            synchronized (o2) {//必须拿到o2才能拿到o1
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}
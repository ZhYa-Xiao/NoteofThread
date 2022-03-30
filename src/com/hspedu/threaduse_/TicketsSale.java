package com.hspedu.threaduse_;

public class TicketsSale {
    public static void main(String[] args) {
        Sall1 sall1 = new Sall1();
        Thread thread = new Thread(sall1);
        Thread thread1 = new Thread(sall1);
        Thread thread2 = new Thread(sall1);

        thread.start();//线程在调用start方法的时候会访问对应runnable对象并调用run方法，此时给该对象加锁，
        // 但这个锁是一个对象，与当前运行的runnable无关，它就是一个对象，是谁都行，只要相同，就代表使用的是相同的锁
        //而跑的代码
        thread1.start();
        thread2.start();
    }
}

class Sall1 implements Runnable{
    private int ticketNum = 100;
    private boolean loop = true;
    Object object = new Object();

    public void m() {
        synchronized (object) {//仅要求括号内的引用能够指向同一个对象，即同一个锁，大括号内的代码块就是厕所
            //厕所只有一个，锁也只有一个
            //给哪个对象加锁并不重要，关键是锁要加到同一个对象上
            //当第二个线程试图如厕时，它必须先能够拿到锁，然后才能加锁
            //厕所就是同步代码
            if(ticketNum <= 0) {
                loop = false;
                System.out.println("票已售完");
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() +
                    "售出一张票,当前还剩余"+ (--ticketNum) +"张票");
        }
    }
    @Override
    public void run() {
        while (loop) {
            m();

        }
    }
}

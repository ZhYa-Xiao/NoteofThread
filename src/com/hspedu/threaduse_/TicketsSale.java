package com.hspedu.threaduse_;

public class TicketsSale {
    public static void main(String[] args) {
        Sall1 sall1 = new Sall1();

        Thread thread = new Thread(sall1);
        Thread thread1 = new Thread(sall1);
        Thread thread2 = new Thread(sall1);

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Sall1 implements Runnable{
    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if(ticketNum <= 0) {
                System.out.println("票已售完");
                break;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票,当前还剩余"+ (--ticketNum) +"张票");
        }
    }
}

package com.hspedu.threaduse_;

public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        Hello hello = new Hello();
        Hi hi = new Hi();
        hello.start();
        hello.start();
        hi.start();
    }
}



class Hello extends Thread {
    @Override
    public void run() {
        int count = 1;
        while (true) {
            if(count > 10) {
                break;
            }
            System.out.println("hello,world" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
        }
    }
}


class Hi extends Thread {
    @Override
    public void run() {
        int count = 1;
        while (true) {
            if(count > 5) {
                break;
            }
            System.out.println("hi" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
        }
    }
}
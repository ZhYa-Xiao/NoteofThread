package com.hspedu.homework_;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Homework001 {

    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);//在一个线程中控制另一个线程可以考虑传入该线程对象
        //在一个线程中控制另一个线程可以考虑传入该线程对象
        a.start();
        b.start();
    }
}

class A extends Thread {
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            int r = (int)(Math.random() * 100) +1;
            System.out.println(r);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A is pass");
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);
    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入");

            char c = scanner.next().toUpperCase().charAt(0);
            if(c == 'Q'){
                a.setLoop(false);
                System.out.println("b线程退出");
                break;
            }
        }
    }


}
package com.hspedu.homework_;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Homework01 {
    public static void main(String[] args) {
        AThread aThread = new AThread();
        BThread bThread = new BThread();
        Thread thread = new Thread(aThread);
        Thread thread1 = new Thread(bThread);
        thread1.setDaemon(true);
        thread.start();
        thread1.start();
    }
}

class AThread implements Runnable,KeyListener{
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
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            return;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}

class BThread extends JFrame implements Runnable {
    public AThread a = null;
    public BThread() {
        a = new AThread();
        this.addKeyListener(a);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("B线程在运行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}




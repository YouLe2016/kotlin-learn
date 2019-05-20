package com.wyl.kotlin._01thread._02共享线程间数据;


public class Test {
    public static void main(String[] args) {
        // 直接卖票的弊端: 各线程间数据并没有共享
//        demo1();
        // 通过Runnable接口方式创建线程,实现数据共享
        demo2();
    }

    // 通过Runnable接口方式创建线程,实现数据共享
    private static void demo2() {
        TicketTask task = new TicketTask();
        new Thread(task, "窗口1").start();
        new Thread(task, "窗口2").start();
        new Thread(task, "窗口3").start();
        new Thread(task, "窗口4").start();
    }

    // 直接卖票的弊端: 各线程间数据并没有共享
    private static void demo1() {
        new TicketThread("窗口1").start();
        new TicketThread("窗口2").start();
        new TicketThread("窗口3").start();
        new TicketThread("窗口4").start();
    }
}

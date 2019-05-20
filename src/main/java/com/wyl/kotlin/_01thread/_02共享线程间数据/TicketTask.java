package com.wyl.kotlin._01thread._02共享线程间数据;

public class TicketTask implements Runnable {
    private int ticket = 1;
    private static final int MAX = 100;

    @Override
    public void run() {
        while (ticket <= MAX) System.out.println(Thread.currentThread().getName() + "卖出第" + ticket++ + "张票");
    }
}

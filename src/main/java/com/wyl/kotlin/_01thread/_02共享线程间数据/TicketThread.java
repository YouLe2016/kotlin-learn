package com.wyl.kotlin._01thread._02共享线程间数据;

import org.jetbrains.annotations.NotNull;

public class TicketThread extends Thread {
    private int ticket = 1;
    private static final int MAX = 100;

    public TicketThread() {
    }

    public TicketThread(@NotNull String name) {
        super(name);
    }

    @Override
    public void run() {
        while (ticket <= MAX) System.out.println(getName() + "卖出第" + ticket++ + "张票");
    }
}

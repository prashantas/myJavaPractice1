package com.gb.misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyPrinterApp {
    private final AtomicInteger integer = new AtomicInteger(1);

    private class Printer implements Runnable {
        private final int id;
        private final int nThread;
        private final Lock lock;
        private final Condition condition;

        public Printer(int id, int nThread, Lock lock, Condition condition) {
            this.id = id;
            this.nThread = nThread;
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (true) {
                    if (integer.get() % nThread != id) {
                        condition.await();
                    } else {
                        System.out.println("Thread[" + id + "]--> " + integer.getAndIncrement());
                        condition.signalAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        MyPrinterApp more = new MyPrinterApp();
        int nThreads = 5;
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
            service.submit(new Thread(more.new Printer(i, nThreads, lock, condition)));
        }
        service.shutdown();
    }
}

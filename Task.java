package test;

import java.util.concurrent.Semaphore;

public class Task implements Runnable {

    private Semaphore sem = new Semaphore(1);
    private static int count = 0;

    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.order();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sem.release();
    }

    private synchronized void order() {
        if (Deposits.queue[count] % 2 == 0)
            Deposits.depositA[count] = Deposits.queue[count];
        else
            Deposits.depositB[count] = Deposits.queue[count];

        count++;
    }

    public static void show() {
        for (int i = 0; i < Deposits.queue.length; i++) {
            System.out.println("DepositA[ " + Deposits.depositA[i] + "] =" + Deposits.depositA[i]);
            System.out.println("DepositB[ " + Deposits.depositB[i] + "] =" + Deposits.depositB[i]);
            System.out.println("Queue[ " + Deposits.queue[i] + "] =" + Deposits.queue[i]);
        }
    }
}

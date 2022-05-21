import java.util.concurrent.Semaphore;

public class Task implements Runnable {

    private Semaphore sem = new Semaphore(1);
    private static int count = 0;

    private void semAcquire() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        this.semAcquire();
        this.order();
        sem.release();
    }

    private synchronized void order() {
        if (Deposits.getItemQueue(Task.count) % 2 == 0)
            Deposits.setItemDepositA(Task.count, Deposits.getItemQueue(Task.count));
        else
            Deposits.setItemDepositB(Task.count, Deposits.getItemQueue(Task.count));

        Task.count++;
    }

    public static void show() {
        for (int i = 0; i < Deposits.QUEUE_LEN; i++) {
            System.out.println("DepositA[ " + i + "] =" + Deposits.getItemDepositA(i));
            System.out.println("DepositB[ " + i + "] =" + Deposits.getItemDepositB(i));
            System.out.println("Queue[ " + i + "] =" + Deposits.getItemQueue(i));
        }
    }
}

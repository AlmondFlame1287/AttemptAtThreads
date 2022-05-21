public class Deposits {
    private static int[] depositA = new int[10];
    private static int[] depositB = new int[10];
    private static final int[] queue = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    public static final int QUEUE_LEN = Deposits.queue.length;

    private Deposits() {
    }

    public static int getItemQueue(int index) {
        return queue[index];
    }

    public static void setItemDepositA(int count, int itemQueue) {
        Deposits.depositA[count] = itemQueue;
    }

    public static int getItemDepositA(int index) {
        return depositA[index];
    }

    public static void setItemDepositB(int count, int itemQueue) {
        Deposits.depositB[count] = itemQueue;
    }

    public static int getItemDepositB(int index) {
        return depositB[index];
    }
}

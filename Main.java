import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService exe = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            exe.submit(new Task());
        }

        exe.awaitTermination(1, TimeUnit.SECONDS);

        Task.show();
    }
}

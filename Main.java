package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService exe = Executors.newCachedThreadPool();

        for (int i = 0; i < 2; i++) {
            exe.submit(new Task());
        }

        Task.show();
    }
}

package demo.se.concurrent;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            print("Run");
            doSomeJob();
            print("Stop");
        });
        thread.start();
        print("Exit");
    }

    private static void print(String message) {
        System.out.printf("[%s] %s\n",
                Thread.currentThread().getName(), message);
    }

    private static void doSomeJob() {
        for (int i = 1; i <= 10; i++) {
            print("Working...");
            wait1sec();
        }
    }

    private static void wait1sec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

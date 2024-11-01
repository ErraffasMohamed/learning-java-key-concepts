package threads;

public class ThreadMain {


    public static void main(String[] args) {
        // Creating thread objects with the NumberPrinter task
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"));
        Thread thread3 = new Thread(new NumberPrinter("Thread 3"));

        // Starting each thread
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish before exiting
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("All threads completed.");
    }
}
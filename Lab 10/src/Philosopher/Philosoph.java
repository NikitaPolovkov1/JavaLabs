package Philosopher;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosoph implements Runnable {
    private int id;
    private Semaphore leftFork;
    private Semaphore rightFork;
    private Random random;
    private int eatingTime;
    private int thinkingTime;
    private int eatCount;

    public Philosoph(int id, Semaphore leftFork, Semaphore rightFork, Random random, int eatingTime, int thinkingTime) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.random = random;
        this.eatingTime = eatingTime;
        this.thinkingTime = thinkingTime;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Philosopher " + id + " is thinking.");
                Thread.sleep(random.nextInt(thinkingTime));

                System.out.println("Philosopher " + id + " is hungry.");
                leftFork.acquire();
                System.out.println("Philosopher " + id + " acquired left fork.");
                rightFork.acquire();
                System.out.println("Philosopher " + id + " acquired right fork.");
                System.out.println("Philosopher " + id + " is eating.");
                Thread.sleep(random.nextInt(eatingTime));
                leftFork.release();
                rightFork.release();
                eatCount++;

                System.out.println("Philosopher " + id + " finished eating. Total eat count: " + eatCount);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

}

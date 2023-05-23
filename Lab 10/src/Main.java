import Philosopher.Philosoph;

import java.util.concurrent.Semaphore;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        final int numPhilosophs = 5;
        final int maxThinkingTime = 1000;
        final int maxEatingTime = 1000;
        Random rand = new Random(10000);
        final int eatingSlots = rand.nextInt();
        final Semaphore[] forks = new Semaphore[numPhilosophs];

        for (int i = 0; i < numPhilosophs; i++) {
            forks[i] = new Semaphore(1);
        }

        final Thread[] threads = new Thread[numPhilosophs];
        for (int i = 0; i < numPhilosophs; i++) {
            final int PhilosophId = i;
            final Semaphore leftFork = forks[PhilosophId];
            final Semaphore rightFork = forks[(PhilosophId + 1) % numPhilosophs];
            final Philosoph Philosoph = new Philosoph(
                    PhilosophId,
                    leftFork,
                    rightFork,
                    rand,
                    maxThinkingTime,
                    maxEatingTime
            );
            threads[PhilosophId] = new Thread(Philosoph);
            threads[PhilosophId].start();
        }

        final int controlTime = 5000;
        try {
            Thread.sleep(controlTime);
        } catch (InterruptedException e) {
            System.out.println("Control thread was interrupted.");
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < numPhilosophs; i++) {
            threads[i].interrupt();
        }

    }
}
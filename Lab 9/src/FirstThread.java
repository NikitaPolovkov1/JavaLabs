public class FirstThread implements Runnable
{
    @Override
    public void run() {
        try {
            System.out.println("I am thread");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

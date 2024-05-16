package bg.smg;

public class CalvinThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

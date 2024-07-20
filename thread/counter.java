public class counter implements Runnable {

    int counter = 0;

    @Override
    public void run() {
        System.out.println("Locked in " + Thread.currentThread().getName());
        synchronized(this) {
            System.out.println("Synchronized in " + Thread.currentThread().getName());
            while(counter < 100) {
                System.out.println(Thread.currentThread().getName() + "- Count: " + counter);
                counter++;
            }
            System.out.println("After While" + Thread.currentThread().getName());
        }
        System.out.println("Outside synchronized block " + Thread.currentThread().getName());
    }
}

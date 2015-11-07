
public class JAVATHREADMASTER {
    public static void main(String []args) throws InterruptedException {
        Thread.currentThread().setName("Master ");
        WORKER worker = new WORKER();
        worker.setName("Worker ");
        worker.start();
        Thread.currentThread().join();
        System.out.println(Thread.currentThread().getName());
 }
}

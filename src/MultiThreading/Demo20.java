package MultiThreading;

class Demo20 {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Worker completed");
        });

        worker.start();

        worker.join();

        System.out.println("Main continues");
    }
}
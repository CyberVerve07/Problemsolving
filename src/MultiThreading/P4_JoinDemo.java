package MultiThreading;

/**
 * Question 4: join() Method Demo
 * --------------------------------
 * join() method ek thread ko tab tak wait karwata hai jab tak ki doosra target thread
 * apni execution complete (terminate) na kar le.
 *
 * Key Points:
 * 1. Ye instance method hai: threadObj.join()
 * 2. Calling thread WAITING (ya TIMED_WAITING) state me chala jata hai.
 * 3. Real-world use case: Jab main thread ko background worker tasks (data fetching/processing)
 *    ke result ka wait karna ho final summary banane se pehle.
 */
public class P4_JoinDemo {

    public static void main(String[] args) {
        System.out.println("Main thread started: Initializing application tasks...");

        // Task 1: Fetching User Data
        Thread fetchUserData = new Thread(() -> {
            try {
                System.out.println("fetchingUserData thread started...");
                Thread.sleep(1500); // 1.5 second lagte hain data lane me
                System.out.println("fetchingUserData: User details fetched successfully.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "UserDataThread");

        // Task 2: Fetching Account Balance
        Thread fetchBalance = new Thread(() -> {
            try {
                System.out.println("fetchBalance thread started...");
                Thread.sleep(1000); // 1 second lagta hai balance lane me
                System.out.println("fetchBalance: Balance data fetched successfully.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BalanceThread");

        fetchUserData.start();
        fetchBalance.start();

        try {
            // Main thread dono threads ke complete hone ka wait karega
            System.out.println("Main thread is waiting for UserData and Balance threads using join()...");
            fetchUserData.join();
            fetchBalance.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ye code tabhi chalega jab dono threads finish ho chuki hongi
        System.out.println("All data received! Main thread proceeding to render Dashboard.");
    }
}

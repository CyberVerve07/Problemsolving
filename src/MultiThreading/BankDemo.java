package MultiThreading;

class BankAccount {
    int balance = 1000;

    void withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
        }
    }
}
//At a time, only one thread can acquire the required monitor lock and execute
// the synchronized code guarded by that lock.
//we are controlling the order of access to shared resources.
//Only one thread at a time can execute the synchronized critical section protected by the same lock.
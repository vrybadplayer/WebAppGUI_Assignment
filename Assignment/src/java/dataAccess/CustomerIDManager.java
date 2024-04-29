package dataAccess;

public class CustomerIDManager {
    private static int lastCustID = 1000; // Default starting value

    // Method to retrieve the next customer ID
    public static synchronized int getNextCustomerID() {
        return ++lastCustID;
    }

    // Method to initialize the last assigned customer ID
    public static synchronized void initializeLastCustomerID(int lastID) {
        lastCustID = lastID;
    }
}

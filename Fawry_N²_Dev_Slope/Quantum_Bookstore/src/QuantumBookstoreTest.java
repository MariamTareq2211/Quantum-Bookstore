import java.time.LocalDate;

public class QuantumBookstoreTest {
    public static void runTest() {
        InventoryManagment inventory = new InventoryManagment();

        try {
            // Add books
            inventory.addBook("PAPER001", LocalDate.of(2010, 5, 1), "Java Basics", 150, "Tarek Ismail", "paper", 10, null);
            inventory.addBook("EBOOK001", LocalDate.of(2022, 7, 1), "Python Mastery", 100, "Ismail Tarek", "ebook", null, "PDF");
            inventory.addBook("SHOW001", LocalDate.of(2015, 1, 1), "Design Patterns", 0, "Mariam Tarek", "showcase", null, null);
            inventory.addBook("PAPER002", LocalDate.of(2005, 3, 10), "C++ in Depth", 120, "Mohamed Tarek", "paper", 5, null);

            System.out.println("\nAttempt to buy a paper book:");
            inventory.buyBook("PAPER001", 2, "user@example.com", "Giza, Egypt");

            System.out.println("\nAttempt to buy an ebook:");
            inventory.buyBook("EBOOK001", 1, "reader@domain.com", null);

            System.out.println("\nAttempt to buy a showcase book (should fail):");
            inventory.buyBook("SHOW001", 1, "demo@domain.com", null);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nRemoving books older than 15 years:");
        inventory.removeOutdatedBooks(15);

        System.out.println("\nRemaining books in inventory:");
        for (Book book : inventory.getInventory().values()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getISBN() + ")");
        }
    }
}

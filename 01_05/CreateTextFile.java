import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    private Formatter output;

    public void openFile() {
        try {
            output = new Formatter("clients.txt");
        } catch (SecurityException securityException) {
            System.err.println("You don't have write access to this file.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening or creating file.");
            System.exit(1);
        }
    }

    public void addRecords() {
        AccountRecord record = new AccountRecord();
        Scanner input = new Scanner(System.in);

        System.out.printf("%s\n%s\n%s\n%s\n\n",
            "To terminate input, type the end-of-file indicator",
            "When you are prompted to enter input.",
            "On UNIX/Linux/Mac OS X type CTRL + D then press Enter",
            "On Windows type CTRL + Z then press Enter");

        System.out.print("Enter account number (> 0), first name, last name and balance.\n");

        while (input.hasNext()) {
            try {
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());

                if (record.getAccount() > 0) {
                    output.format("%d %s %s %.2f\n", 
                        record.getAccount(), 
                        record.getFirstName(),
                        record.getLastName(),
                        record.getBalance());
                } else {
                    System.out.println("Account number must be greater than 0.");
                }
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to file.");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine();
            }

            System.out.print("Enter account number (> 0), first name, last name and balance.\n");
        }
    }

    public void closeFile() {
        if (output != null) output.close();
    }
}

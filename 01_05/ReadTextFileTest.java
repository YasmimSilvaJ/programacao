/**
 * ReadTextFileTest
 */
public class ReadTextFileTest {
    public static void main(String[] args) {
        ReadTextFile application = new ReadTextFile();

        application.openFile();
        application.readRecords();
        application.closeFile();
    }
}
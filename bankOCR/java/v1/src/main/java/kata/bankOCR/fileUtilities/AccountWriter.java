package kata.bankOCR.fileUtilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/9/12
 * Time: 10:52 PM
 * Kata Practise.
 */
public class AccountWriter {
    private String filename;
    private BufferedWriter accountWriter;

    public AccountWriter(String filename) throws IOException{
        this.filename = filename;
        accountWriter = new BufferedWriter(new FileWriter(filename));
    }

    public void writeAccount(String accountString) throws IOException{
        accountWriter.write(accountString);
    }

    public void close() throws IOException{
        accountWriter.close();
    }
}

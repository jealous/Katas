package kata.bankOCR.fileUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Cedric
 * Date: 4/9/12
 * Time: 10:16 PM
 * Kata Practise.
 */
public class AccountReader {
    private String filename;
    private BufferedReader reader;
    
    public AccountReader(String filename) throws FileNotFoundException{
        this.filename = filename;
        reader = new BufferedReader(new FileReader(filename));
    }
    
    public String[] readAccount() throws Exception{
        String[] account = new String[3];
        for (int i = 0; i < 3 ; i++){
            account[i] = reader.readLine();
            if (!isValidLine(account[i])){
                account = new String[0];
                return account;
            }
        }
        readAccountSeparatorLine();
        return account;
    }
    
    
    private boolean isValidLine(String line) throws IllegalArgumentException{
        boolean retVal = checkEndOfFile(line);
        if (retVal){
            checkLineLength(line);
        }
        return retVal;

    }
    
    private void checkLineLength(String line){
        if (line.length() != 27){
            throw new IllegalArgumentException("Not a valid line for account.");
        }
    }
    
    private boolean checkEndOfFile(String line){
        boolean retVal = true;
        if (line == null){
            retVal = false;
        }
        return retVal;
    }

    private void readAccountSeparatorLine() throws IOException{
        reader.readLine();
    }
    
    public void close(){
        try{
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

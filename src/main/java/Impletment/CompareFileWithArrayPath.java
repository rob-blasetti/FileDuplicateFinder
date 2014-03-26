package Impletment;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by leng on 26/03/2014.
 */
public class CompareFileWithArrayPath {
    public ArrayList<String> compareFiles(String[] arrayPath) throws FileNotFoundException {

        StreamHashCalculator streamHashCalculator = new StreamHashCalculator();
        String[] hashCodes = new String[arrayPath.length];
        for (int i = 0; i < arrayPath.length; i++) {
            FileInputStream fileInputStream = new FileInputStream(arrayPath[i]);
            hashCodes[i] = streamHashCalculator.generateHashCode(fileInputStream);
        }
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < hashCodes.length - 1; i++) {
            for (int j = 1; j < hashCodes.length; j++) {
                if (i != j) {
                    if (hashCodes[i].equals(hashCodes[j])) {
                        result.add(arrayPath[i]);
                        result.add(arrayPath[j]);
                    }
                }
            }
        }
        if (result.size() > 0) return result;
        return null;
    }
}


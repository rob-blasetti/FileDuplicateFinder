package Impletment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leng on 19/03/2014.
 */
public class CompareFileWithHashingCode {
    private HashMap<String, List<String>> hashMap;

    public CompareFileWithHashingCode() {
        hashMap = new HashMap<String, List<String>>();

    }

    public HashMap<String, List<String>> findDuplicatedFile(File file, StreamHashCalculator streamHashCalculator) {

        File files[] = file.listFiles();
        for (File f : files) {

            if (f.isDirectory()) {
                findDuplicatedFile(f, streamHashCalculator);
            } else {
                try {
                    String key = streamHashCalculator.generateHashCode(new FileInputStream(f));
                    if (hashMap.containsKey(key)) {
                        hashMap.get(key).add(f.getAbsolutePath());
                    } else {
                        List<String> list = new ArrayList<String>();
                        list.add(f.getAbsolutePath());
                        hashMap.put(key, list);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }
}

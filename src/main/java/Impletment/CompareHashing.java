package Impletment;

import HashingMD5.HashingMD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leng on 19/03/2014.
 */
public class CompareHashing {
    private HashMap<String, List<String>> hashMap;

    public CompareHashing() {
        hashMap = new HashMap<String, List<String>>();

    }

    public HashMap<String, List<String>> findDuplicatedFile(File file, HashingMD5 hashingMD5) {

        File files[] = file.listFiles();
        for (File f : files) {

            if (f.isDirectory()) {
                findDuplicatedFile(file, hashingMD5);
            } else {
                try {
                    hashingMD5.setFile(new FileInputStream(f));
                    String key = hashingMD5.generateHashCode();
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

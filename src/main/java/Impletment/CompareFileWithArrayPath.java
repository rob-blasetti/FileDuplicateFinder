package Impletment;


import Interface.FileStreamOpener;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by leng on 26/03/2014.
 */
public class CompareFileWithArrayPath {

    private final FileStreamOpener fileStreamOpener;

    public CompareFileWithArrayPath(FileStreamOpener fileStreamOpener) {
        this.fileStreamOpener = fileStreamOpener;
    }

    public ArrayList<String> compareFiles(String[] arrayPath) throws FileNotFoundException {

//        StreamHashCalculator streamHashCalculator = new StreamHashCalculator();
//        String[] hashCodes = new String[arrayPath.length];
//        for (int i = 0; i < arrayPath.length; i++) {
//            FileInputStream fileInputStream = new FileInputStream(arrayPath[i]);
//            hashCodes[i] = streamHashCalculator.generateHashCode(fileInputStream);
//        }
//        ArrayList<String> result = new ArrayList<String>();
//        for (int i = 0; i < hashCodes.length - 1; i++) {
//            for (int j = 1; j < hashCodes.length; j++) {
//                if (i != j) {
//                    if (hashCodes[i].equals(hashCodes[j])) {
//                        result.add(arrayPath[i]);
//                        result.add(arrayPath[j]);
//                    }
//                }
//            }
//        }
//        if (result.size() > 0) return result;

        Hashtable<String, ArrayList<String>> hashToPathsMap = new Hashtable<String, ArrayList<String>>();

        for (String path : arrayPath) {
            String hash = calculateHash(path);
            if (!hashToPathsMap.containsKey(hash)) {
                hashToPathsMap.put(hash, new ArrayList<String>());
            }
            hashToPathsMap.get(hash).add(path);
        }

        for (String hash : hashToPathsMap.keySet()) {
            if (hashToPathsMap.get(hash).size() > 1)
                return hashToPathsMap.get(hash);
        }

        return null;
    }

    private String calculateHash(String path) {
        InputStream stream = openFileStream(path);
        return calculateHash(stream);
    }

    protected InputStream openFileStream(String path) {
        return fileStreamOpener.open(path);
    }

    private String calculateHash(InputStream stream) {
        StreamHashCalculator hashCalculator = new StreamHashCalculator();
        return hashCalculator.generateHashCode(stream);
    }
}


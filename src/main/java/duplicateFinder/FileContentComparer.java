package duplicateFinder;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by leng on 26/03/2014.
 */
public class FileContentComparer {

    private final FileStreamOpener fileStreamOpener;

    public FileContentComparer(FileStreamOpener fileStreamOpener) {
        this.fileStreamOpener = fileStreamOpener;
    }

    public HashMap<String, ArrayList<String>> compareFiles(String[] filePaths) throws FileNotFoundException {

        Hashtable<String, ArrayList<String>> hashToPathsMap = new Hashtable<String, ArrayList<String>>();

        for (String path : filePaths) {
            String hash = calculateHash(path);
            if (!hashToPathsMap.containsKey(hash)) {
                hashToPathsMap.put(hash, new ArrayList<String>());
            }
            hashToPathsMap.get(hash).add(path);
        }

        HashMap<String, ArrayList<String>> dupllicatedFilesToDictionary = new HashMap<String, ArrayList<String>>();
        for (String hash : hashToPathsMap.keySet()) {
            if (hashToPathsMap.get(hash).size() > 1)
                dupllicatedFilesToDictionary.put(hash, hashToPathsMap.get(hash));
        }
        if (dupllicatedFilesToDictionary.size() > 0) {
            return dupllicatedFilesToDictionary;
        }

        return null;
    }

    private String calculateHash(String path) {
        InputStream stream = openFileStream(path);
        return calculateHash(stream);
    }

    private InputStream openFileStream(String path) {
        return fileStreamOpener.open(path);
    }

    private String calculateHash(InputStream stream) {
        StreamHashCalculator hashCalculator = new StreamHashCalculator();
        return hashCalculator.generateHashCode(stream);
    }
}


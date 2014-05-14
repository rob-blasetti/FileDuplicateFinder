package duplicateFinder;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leng on 30/04/2014.
 */
public class DuplicateFinder {
    private FileClassifierBySize fileClassifierBySize;
    private FileContentComparer fileContentComparer;
    private DuplicateFinderProcessor processor;


    public DuplicateFinder(DuplicateFinderProcessor processor, FileClassifierBySize fileClassifierBySize, FileContentComparer fileContentComparer) {
        this.fileClassifierBySize = fileClassifierBySize;
        this.fileContentComparer = fileContentComparer;
        this.processor = processor;
    }

    public void scan(String pathToScan) throws FileNotFoundException {
        Map<String, ArrayList<String>> dictionaryOfFileClassifiedBySize = fileClassifierBySize.scanDirectory(pathToScan);

        for (String key : dictionaryOfFileClassifiedBySize.keySet()) {
            ArrayList<String> arrayListOfPath = dictionaryOfFileClassifiedBySize.get(key);
            HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles =
                    fileContentComparer.compareFiles(arrayListOfPath.toArray(new String[arrayListOfPath.size()]));
            processor.execute(dictionaryOfDuplicateFiles);
        }
    }
}

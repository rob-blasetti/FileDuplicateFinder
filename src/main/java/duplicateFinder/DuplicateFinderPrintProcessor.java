package duplicateFinder;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leng on 30/04/2014.
 */
public class DuplicateFinderPrintProcessor implements DuplicateFinderProcessor {
    private FileClassifierBySize2 fileClassifierBySize2;
    private FileContentComparer fileContentComparer;
    private Outputter outputter;


    public DuplicateFinderPrintProcessor(Outputter outputter, FileClassifierBySize2 fileClassifierBySize, FileContentComparer fileContentComparer) {
        this.fileClassifierBySize2 = fileClassifierBySize;
        this.fileContentComparer = fileContentComparer;
        this.outputter = outputter;
    }

    @Override
    public void execute(String pathToScan) throws FileNotFoundException {
        Map<String, ArrayList<String>> dictionaryOfFileClassifiedBySize = fileClassifierBySize2.scanDirectory(pathToScan);

        for (String key : dictionaryOfFileClassifiedBySize.keySet()) {
            outputter.writeLine(key + " bytes");
            ArrayList<String> arrayListOfPath = dictionaryOfFileClassifiedBySize.get(key);
            HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles =
                    fileContentComparer.compareFiles(arrayListOfPath.toArray(new String[arrayListOfPath.size()]));
            String result = new StringFormatter().formatData(dictionaryOfDuplicateFiles);
            outputter.writeLine(result);
        }
    }
}

package duplicateFinder;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leng on 30/04/2014.
 */
public class DuplicateFinder {
    private PathInput pathInput;
    private PathScanner pathScanner;
    private FileClassifierBySize2 fileClassifierBySize2;
    private FileSizeReader fileSizeReader;
    private FileContentComparer fileContentComparer;
    private FileStreamOpener fileStreamOpener;
    private Formatter formatter;
    private Outputter outputter;


    public DuplicateFinder() throws FileNotFoundException {

        pathInput = new PathInput();
        fileSizeReader = new FileSizeReader();
        pathScanner = new PathScanner();
        fileClassifierBySize2 = new FileClassifierBySize2(pathScanner, fileSizeReader);

        fileStreamOpener = new FileStreamOpenerImplement();
        fileContentComparer = new FileContentComparer(fileStreamOpener);

        formatter = new StringFormatter();
        outputter = new ScreenOutput();

        Map<String, ArrayList<String>> dictionaryOfFileClassifiedBySize = fileClassifierBySize2.scanDirectory(pathInput.getUserPath());

        for (String key : dictionaryOfFileClassifiedBySize.keySet()) {
            outputter.writeLine(key + " bytes");
            ArrayList<String> arrayListOfPath = dictionaryOfFileClassifiedBySize.get(key);
            HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles = fileContentComparer.compareFiles(arrayListOfPath.toArray(new String[arrayListOfPath.size()]));
            String result = formatter.formatData(dictionaryOfDuplicateFiles);
            outputter.writeLine(result);
        }


    }
}

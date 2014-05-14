package duplicateFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leng on 14/05/2014.
 */
public class DuplicateFinderDeleteProcessor implements DuplicateFinderProcessor {

    private FileClassifierBySize2 fileClassifierBySize2;
    private FileContentComparer fileContentComparer;
    private Outputter outputter;
    private DeleteFile deleteFile;

    public DuplicateFinderDeleteProcessor(Outputter outputter, FileClassifierBySize2 fileClassifierBySize, FileContentComparer fileContentComparer, DeleteFile deleteFile) {
        this.fileClassifierBySize2 = fileClassifierBySize;
        this.fileContentComparer = fileContentComparer;
        this.outputter = outputter;
        this.deleteFile = deleteFile;
    }

    @Override
    public void execute(String pathToScan) throws FileNotFoundException {

        Map<String, ArrayList<String>> dictionaryOfFileClassifiedBySize = fileClassifierBySize2.scanDirectory(pathToScan);

        for (String key : dictionaryOfFileClassifiedBySize.keySet()) {

            ArrayList<String> arrayListOfPath = dictionaryOfFileClassifiedBySize.get(key);
            HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles =
                    fileContentComparer.compareFiles(arrayListOfPath.toArray(new String[arrayListOfPath.size()]));

            HashMap<String, ArrayList<String>> dictionaryOfRemainFiles = new HashMap<String, ArrayList<String>>();

            if (dictionaryOfDuplicateFiles != null) {
                for (String hashKey : dictionaryOfDuplicateFiles.keySet()) {

                    ArrayList<String> filePaths = dictionaryOfDuplicateFiles.get(hashKey);

                    ArrayList<String> deleteList = new ArrayList<String>();
                    deleteList.add(filePaths.get(0));
                    dictionaryOfRemainFiles.put(hashKey, deleteList);

                    for (int i = 1; i < filePaths.size(); i++) {
                        deleteFile.delete(new File(filePaths.get(i)));
                    }
                }
                String result = new StringFormatter().formatData(dictionaryOfRemainFiles);
                outputter.writeLine(result);
            }
        }
    }
}

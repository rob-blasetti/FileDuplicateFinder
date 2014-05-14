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

    private FileDeleter fileDeleter;
    private Outputter outputter;

    public DuplicateFinderDeleteProcessor(FileDeleter fileDeleter, Outputter outputter) {

        this.fileDeleter = fileDeleter;
        this.outputter = outputter;
    }


    @Override
    public void execute(HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        if (dictionaryOfDuplicateFiles != null) {
            for (String hashKey : dictionaryOfDuplicateFiles.keySet()) {
                ArrayList<String> filePaths = dictionaryOfDuplicateFiles.get(hashKey);
                for (int i = 1; i < filePaths.size(); i++) {
                    if (fileDeleter.delete(new File(filePaths.get(i)))) {
                        result.append(filePaths.get(i));
                        result.append("\n");
                    }
                }
            }
        }
        outputter.writeLine(result.toString());
    }
}

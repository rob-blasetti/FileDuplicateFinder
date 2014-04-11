package duplicateFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/04/2014
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileClassifierBySize {
    private HashMap<String, ArrayList<String>> fileSizeToFilePathsMap;

    public FileClassifierBySize() {
        fileSizeToFilePathsMap = new HashMap<String, ArrayList<String>>();
    }

    public HashMap<String, ArrayList<String>> scanDirectory(File files) {

        if (files == null) {
            return null;
        }
        scanThroughDirectoryWithGivenFile(files);

        return fileSizeToFilePathsMap;
    }

    private void scanThroughDirectoryWithGivenFile(File folder) {
        File files[] = folder.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                scanThroughDirectoryWithGivenFile(f);
            } else {
                long fileSize = f.length();
                String fileSizeAsKey = fileSize + "";
                if (fileSizeToFilePathsMap.containsKey(fileSizeAsKey)) {
                    fileSizeToFilePathsMap.get(fileSizeAsKey).add(f.getAbsolutePath());
                } else {
                    ArrayList<String> listOfFilePaths = new ArrayList<String>();
                    listOfFilePaths.add(f.getAbsolutePath());
                    fileSizeToFilePathsMap.put(fileSizeAsKey, listOfFilePaths);
                }
            }

        }

    }
}

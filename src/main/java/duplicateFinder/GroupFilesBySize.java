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
public class GroupFilesBySize {
    private HashMap<String, ArrayList<String>> groupedFileByItsSizeFromGivenPath;
    public GroupFilesBySize ()

    {
        groupedFileByItsSizeFromGivenPath = new HashMap<String, ArrayList<String>>();
    }

    public HashMap<String, ArrayList<String>> scanDirectoryWithGivenPath(String path) {

        if (path == null || path.trim().equals("")) {
            return null;
        }
        File file=new File(path);
        scanThroughDirectoryWithGivenFile(file);

        return  groupedFileByItsSizeFromGivenPath;
    }

    private void scanThroughDirectoryWithGivenFile(File file){
         File files[]=file.listFiles();
         for (File f:files){
             if(f.isDirectory()){
                 scanThroughDirectoryWithGivenFile(f);
             } else{
                long fileSize=f.length();
                String fileSizeAsKey=fileSize+"";
                if(groupedFileByItsSizeFromGivenPath.containsKey(fileSizeAsKey)){
                    groupedFileByItsSizeFromGivenPath.get(fileSizeAsKey).add(f.getAbsolutePath());
                } else{
                    ArrayList<String> listOfFilePaths= new ArrayList<String>();
                    listOfFilePaths.add(f.getAbsolutePath());
                    groupedFileByItsSizeFromGivenPath.put(fileSizeAsKey,listOfFilePaths);

                }

             }

         }

    }


}
